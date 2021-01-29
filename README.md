# Jelly-Music 1.0.0
------------
## Contents
1. 프로젝트 계획 이유
2. 설계의 주안점
3. Using
4. 업무일정
5. Jelly-Music 기능 설명
6. Document
7. 추후 구현 예정 기능
------------
## 프로젝트 계획 이유
> 음악 스트리밍 사이트와 동영상 스트리밍 사이트 등 여러 스트리밍 사이트를 구독하면서 많은 사이트들이 추천 알고리즘에 집중하고 있다는 것을 알게 되었습니다. '알고리즘의 선택'이라는 말이 생길 만큼 이제는 알고리즘이 단순한 추천을 넘어서 숨어있던 컨텐츠들을 유명하게 만드는 역할까지 하고 있습니다.
>
> 이러한 경험을 바탕으로 프로젝트를 개발하게 되었습니다. 음악 추천 사이트에서 시작한 아이디어는 음악 플레이 뿐만 아니라 음원, 앨범, 아티스트 정보 제공과 사용자들끼리의 소통을 위한 댓글 기능도 추가하였습니다. 또한 사이트 운영을 위한 관리자 페이지도 만들어 회원 관리와 음원 관리를 할 수 있게 했습니다.
>
> 이 프로그램은 CRUD 기능을 바탕으로 구현되었습니다. 
> 사용자의 눈길을 끌고 추천 알고리즘을 위한 프로세스 진행을 위해 통통 튀는 UI로 지루하지 않은 경험을 제공했습니다.
------------
## 설계의 주안점
1. HTML, CSS, jQuery, JavaScript를 이용한 Jelly처럼 통통 튀고 화려한 UI 구성
2. MVC Model 2를 이용한 CRUD 기능
3. 추천 알고리즘을 위한 최초 아티스트&장르 취향 선택 시 즐거운 경험을 주기 위한 움직이는 UI
4. AJAX를 이용한 데이터 처리
5. 음원, 아티스트, 앨범 더보기 시 회원 자신의 생각을 공유&회원간 소통을 위한 댓글 기능 구현
------------
## Using
1. FrontEnd - HTML5, JS, CSS3, jQuery
2. BackEnd - Java(JDK 1.8), Servlet
3. OS - Windows, MacOS
4. Library&API - OJDBC, COS, JSTL
5. IDE - Eclipse (EE, 2020-06)
6. Server - Tomcat(v8.5)
7. Document - Google Drive, StarUML
8. Cl - Github, git
9. DataBase - Oracle DataBase 11g
------------
## 업무일정
<img width="1680" alt="스크린샷 2021-01-29 오후 5 27 46" src="https://user-images.githubusercontent.com/72774483/106250839-82bc7e00-6257-11eb-99c6-11093acd3bc5.png">

------------
## Jelly-Music 기능 설명
### [mode 선택 기능]
1. Manager 기능 : 관리자가 사용하는 기능
> + 관리자와 회원 화면 분리
> + 회원관리, 파일관리, 게시판 관리 기능
2. Guest 기능 : 손님이 사용하는 기능
> + 비회원, 회원, 이용권 유무에 따른 기능 분리
> + 음악 플레이, 댓글, 좋아요 기능 등

### [Manager, 관리자 기능]
1. Manage Member
> + 전체 회원 조회 기능
> + 회원 검색 기능
2. Upload File
> + 파일 등록 기능
> + 파일 목록 조회 기능 (추후 구현 예정)
3. Manage Post
> + 공지사항 조회, 등록, 수정, 삭제 기능
> + 자주하는 질문 조회, 카테고리별 조회 기능
> + Q&A 관리 기능 (추후 구현 예정)
4. Statistics (추후 구현 예정)

### [Guest, 손님 기능]
1. Register
> + 회원가입 기능
> + 선호 아티스트, 장르 선택
>  <img width="985" alt="스크린샷 2021-01-29 오후 5 10 06" src="https://user-images.githubusercontent.com/72774483/106249622-f1004100-6255-11eb-959b-81f37c2e4050.png">
>  <img width="983" alt="스크린샷 2021-01-29 오후 5 10 17" src="https://user-images.githubusercontent.com/72774483/106249674-05443e00-6256-11eb-9dce-0cb34fffc9f0.png">
>
>      + 각 3개씩 선택 시 데이터 insert, 후에 음악 추천시 영향
> + 회원가입 완료 시 최근 재생 음악 바로 플레이를 위한 임시 데이터 insert 기능
> <img width="983" alt="스크린샷 2021-01-29 오후 5 10 33" src="https://user-images.githubusercontent.com/72774483/106249865-3ae92700-6256-11eb-9517-dca9c1e2e5f1.png">
>
2. Login
> + 로그인 시 세션 생성 기능 - 아이디, 멤버쉽 유무
3. List
> <img width="982" alt="스크린샷 2021-01-29 오후 5 09 34" src="https://user-images.githubusercontent.com/72774483/106249436-b5fe0d80-6255-11eb-9dbd-252b0f68e5cb.png">
><img width="985" alt="스크린샷 2021-01-29 오후 5 10 45" src="https://user-images.githubusercontent.com/72774483/106249961-5a804f80-6256-11eb-9941-a824135c1fdb.png">
><img width="985" alt="스크린샷 2021-01-29 오후 5 11 05" src="https://user-images.githubusercontent.com/72774483/106250442-fca03780-6256-11eb-99e4-c472df4e4cb9.png">
>
> + 비회원
>      + TOP 100, Heart 차트, 장르별, 무드별 음악 리스트 확인 기능
> + 회원
>      + 추천 음악, 추천 아티스트, TOP 100, Heart 차트, 장르별, 무드별 음악 리스트 확인 기능
4. Search (추후 구현 예정)
5. Real-Time Search
> + 검색 수에 따라 실시간 검색어 변동 기능
6. PLAYER
><img width="984" alt="스크린샷 2021-01-29 오후 5 11 25" src="https://user-images.githubusercontent.com/72774483/106250486-0c1f8080-6257-11eb-8015-35f91ca51bb5.png">
><img width="987" alt="스크린샷 2021-01-29 오후 5 11 37" src="https://user-images.githubusercontent.com/72774483/106250526-1a6d9c80-6257-11eb-940a-eeff4dff26c9.png">
>
> + 회원(이용권 무)
>      + 이용권 유무 검사 기능
>      + 1분 미리듣기 후 이용권 페이지 이동 기능
>      + 음악 실행 시 회원 플레이스트 추가 기능
>      + 플레이리스트에서 삭제 기능
>      + 하트 클릭 시 Heart 테이블에 데이터 insert, 후에 음악 추천시 영향
> + 회원(이용권 유)
>      + 이용권 유무 검사 기능
>      + 완곡 재생 기능
>      + 음악 실행 시 회원 플레이스트 추가 기능
>      + 플레이리스트에서 삭제 기능
>      + 하트 클릭 시 Heart 테이블에 데이터 insert, 후에 음악 추천시 영향
> + 음악 랜덤 재생, 전곡 무한 듣기 (추후 구현 예정)
7. More
> + 음원, 아티스트, 앨범 정보 확인 기능
> + 회원
>      + 댓글 작성, 수정, 삭제 기능
>      + 댓글 신고 기능
>      + 음원 플레이리스트 추가, 재생 기능
8. Membership
> + 멤버쉽 구매 후 완곡 듣기 가능하게 데이터 update 하는 기능
9. Logout
> + 로그아웃 후 세션 삭제 기능
------------
## Document
1. 기능정의서
<img width="1680" alt="스크린샷 2021-01-29 오후 5 47 12" src="https://user-images.githubusercontent.com/72774483/106252832-0c6d4b00-625a-11eb-9a54-f780e331c37e.png">
>
2. 유스케이스
<img width="1680" alt="스크린샷 2021-01-29 오후 5 28 01" src="https://user-images.githubusercontent.com/72774483/106251055-da5ae980-6257-11eb-8c55-f55ab7c8824f.png">
<img width="1680" alt="스크린샷 2021-01-29 오후 5 28 12" src="https://user-images.githubusercontent.com/72774483/106251121-ee065000-6257-11eb-9330-50683352348d.png">
>
3. UI 설계서
<img width="1680" alt="스크린샷 2021-01-29 오후 5 45 00 1" src="https://user-images.githubusercontent.com/72774483/106252928-2c047380-625a-11eb-83f4-aa6b9f29f232.png">
>
4. ERD
<img width="1680" alt="스크린샷 2021-01-29 오후 5 28 35" src="https://user-images.githubusercontent.com/72774483/106251161-fd859900-6257-11eb-80f1-6775520085ce.png">

5. 테이블 정의서
<img width="1680" alt="스크린샷 2021-01-29 오후 5 44 31" src="https://user-images.githubusercontent.com/72774483/106252986-3cb4e980-625a-11eb-892a-28afb9437914.png">
>
6. 클래스 다이어그램
<img width="1680" alt="스크린샷 2021-01-29 오후 5 44 41" src="https://user-images.githubusercontent.com/72774483/106253061-581ff480-625a-11eb-9121-ee30a53d1a84.png">
>
7. 시퀀스 다이어그램
<img width="1680" alt="스크린샷 2021-01-29 오후 5 42 07" src="https://user-images.githubusercontent.com/72774483/106253137-72f26900-625a-11eb-9c62-d96465389e35.png">
>
------------
## 추후 구현 예정 기능
1. 파일 목록 조회 기능
2. Q&A 관리 기능
3. 사이트 통계 기능
4. 음원, 아티스트, 장르, 무드 검색 기능
5. 플레이어 랜덤 재생, 전곡 무한 듣기 기능