<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="../js/common/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="../js/common/bootstrap.min.js"></script>
	<script type="text/javascript" src="../js/user/userLogin.js"></script>
	<script type="text/javascript" src="../js/common/common.js"></script>
	<link href="../css/common.css" rel="stylesheet" type="text/css">
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
    <!-- 네비게이션 -->
    <div class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <span class="sr-only">Chatting</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="../"><span>Chatting</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul class="nav navbar-nav navbar-right">
          	<li>
              <a href="../"><span class="glyphicon glyphicon-home"></span> Home</a>
            </li>
            <li>
              <a href="#" onclick="roomList();"><span class="glyphicon glyphicon-tasks"></span> Room List</a>
            </li>
            <li>
              <a href="#" onclick="myInfo();"><span class="glyphicon glyphicon-user"></span> My Info</a>
            </li>
            <li class="active">
              <c:choose>
                <c:when test="${not empty sessionScope.loginInfo}">
                  <c:forEach var="loginInfo" items="${sessionScope.loginInfo}">
                    <a href="#" onclick="sessionLogout();"><span class="glyphicon glyphicon-off"></span> Logout</a>
                  </c:forEach>
                </c:when>
                <c:otherwise>
                  <a href="#" onclick="sessionLogin();"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                </c:otherwise>
              </c:choose>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <!-- 입력 영역 -->
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="page-header">
              <h2>로그인
                <small>회원 로그인</small>
              </h2>
            </div>
            <form class="form-horizontal" role="form" name="loginFrm" action="javascript:userLogin();">
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">아이디</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="아이디를 입력해주세요" id="user_id">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">비밀번호</label>
                </div>
                <div class="col-sm-10">
                  <input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" id="user_pwd" onchange="pwdValueChange(this.value);">
                  <small class="text-red" id="randPwdText" style="display:none">변경된 비밀번호 입력란</small>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-6">
                  <a class="btn btn-block btn-primary" onclick="idSearch();"><span class="glyphicon glyphicon-search"></span> 아이디 찾기</a>
                </div>
                <div class="col-sm-6">
                  <a class="btn btn-block btn-primary" onclick="pwdSearch();"><span class="glyphicon glyphicon-search"></span> 비밀번호 찾기</a>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-12">
                  <button type="submit" class="btn btn-block btn-lg btn-primary">
                    <span class="glyphicon glyphicon-user"></span> 로그인</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </body>

</html>