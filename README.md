# 장바구니

장바구니 미션 저장소

## 기능 요구사항

용어

* 비밀번호 형식: 8 ~ 20(포함), 대문자+소문자+특수기호(!@#$%^&*)+숫자
* 닉네임 형식: 한글 or 영어 or 숫자만 가능. 10자 이하

### 회원가입 기능

- [x] 이메일, 패스워드, 닉네임을 입력 받아 회원가입을 한다.
- [x] 예외사항
    - [x] 이메일 형식이 맞지 않는 경우
    - [x] 패스워드 형식이 맞지 않는 경우
    - [x] 닉네임 형식이 맞지 않는 경우
    - [x] 닉네임이 중복될 경우

### 로그인 기능 
- [x] 이메일과 패스워드를 입력받아 토큰을 반환한다.
- [x] 예외사항
  - [x] 이메일 혹은 패스워드가 일치하지 않는 경우

### 회원탈퇴 기능
- [X] 회원을 삭제한다.

### 회원 정보 조회 기능
- [x] 회원 정보를 반환한다.

### 패스워드 변경 기능
- [x] 이전 패스워드와 새로운 패스워드를 입력받아 새로운 패스워드로 변경한다.
- [x] 예외사항
  - [x] 이전 패스워드가 일치하지 않는 경우
  - [x] 패스워드 형식이 맞지 않는 경우

### 회원 정보 수정 기능
- [x] 새로운 닉네임을 입력받아 회원 정보를 수정한다.
- [x] 예외사항
  - [x] 닉네임이 형식에 맞지 않는 경우
  - [x] 닉네임이 중복되는 경우

### 상품 관련 기능

- [ ] 전체 상품을 조회한다.

- [ ] 단일 상품을 조회한다.
  - [ ] 예외사항
  - [ ] 존재하지 않는 id로 상품 조회를 요청하는 경우

### 장바구니 관련 기능

- [ ] 전체 상품을 조회한다.

- [ ] 상품을 등록한다.

- [ ] 상품 수량을 변경한다.

- [ ] 상품을 삭제한다.


## 고민할 사항

* CartService에서 CustomerDao가 아닌 CustomerService를 의존하도록 만들기 

[API SPEC](https://www.notion.so/awesomeo184/API-SPEC-50fd99cc2ca9486ca5b83ed1958b6a6f)

## ✏️ Code Review Process

[텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
