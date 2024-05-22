<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="kr">
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8">
</head>
<body>
<h1>
	Hello world!
	이 프로젝트는 이제 깃으로 관리합니다.  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<p><a href="/board/list">게시물 목록보기</a></p>
<!--<p><a href="/board/today">오늘 쓴 글 목록</a></p>
<p><a href="/board/rank">작성자별 게시글 수</a></p>-->
<p>댓글 수정,날짜시간 : 완성</p>
<p>댓글 페이징 : 진행중</p>
<p>다른 건 : 미구현</p>

</body>
</html>
