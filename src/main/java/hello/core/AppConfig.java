package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
//after refactoring
public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    public OrderServiceImpl orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
// before refactoring
//public class AppConfig {
//
//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
//
//    public OrderServiceImpl orderService(){
//        return new OrderServiceImpl( new MemoryMemberRepository(), new FixDiscountPolicy());
//    }
//
//}
