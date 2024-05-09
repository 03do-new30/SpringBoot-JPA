# 실전! 스프링 부트와 JPA 활용 1 - 웹 어플리케이션 개발
> 김영한 강사님의 강의를 들으며 스프링 부트와 JPA를 이용해 웹 어플리케이션을 개발했습니다 🥸
> [강의 링크](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-JPA-%ED%99%9C%EC%9A%A9-1)

## 아키텍처
  ![architecture.png](images%2Farchitecture.png)
- controller: 웹 계층
- service: 비즈니스 로직과 트랜잭션을 처리한다
- repository: JPA를 직접 사용하는 계층
- domain: 엔티티가 모여있는 계층

## 사용한 기술
- Spring Boot: Spring을 이용하여 편리하게 애플리케이션을 만들 수 있게 해주는 프레임워크
- JPA: Java ORM 표준 인터페이스
- lombok: 어노테이션을 기반으로 코드를 자동 완성해주는 라이브러리
- H2 Database: 개발 및 테스트 용도로 가볍게 사용하기 좋은 DB
- thymeleaf: 템플릿 엔진

## Preview
![main.png](images%2Fmain.png)

## 회원 기능
### 회원 등록
![member.png](images%2Fmember.png)
### 회원 목록
![memberlist.png](images%2Fmemberlist.png)

## 상품 기능
### 상품 등록
![item.png](images%2Fitem.png)
### 상품 목록
![itemlist.png](images%2Fitemlist.png)

## 주문 기능
### 주문 등록
![order.png](images%2Forder.png)
### 주문 목록
![orderlist.png](images%2Forderlist.png)