<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="./js/common/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="./js/common/bootstrap.min.js"></script>
	<script type="text/javascript" src="./js/common/index.js"></script>
	<link href="./css/common.css" rel="stylesheet" type="text/css">
    <link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
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
          <a class="navbar-brand" href="#"><span>Chatting</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active">
              <a href="#"><span class="glyphicon glyphicon-home"></span> Home</a>
            </li>
            <li>
              <a href="#" onclick="roomList();"><span class="glyphicon glyphicon-tasks"></span> Room List</a>
            </li>
            <li>
              <a href="#" onclick="myInfo();"><span class="glyphicon glyphicon-user"></span> My Info</a>
            </li>
            <li>
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
	<div class="section">
		<div class="container">
			<c:choose>
				<c:when test="${not empty sessionScope.loginInfo}">
					<c:forEach var="loginInfo" items="${sessionScope.loginInfo}">
						<div class="row">
							<div class="col-md-12">
								<div class="jumbotron text-center">
									<h2 class="text-blue">${loginInfo.user_name}님 반갑습니다!</h2>
									<p>
										<span>채팅 시스템을 이용하고 싶으시다면 하단의 채팅방 리스트 버튼을 눌러주세요.</span>
									</p><br/>
									<a class="btn btn-block btn-primary" href="#" onclick="roomList();"><span class="glyphicon glyphicon-list"></span> 채팅방 리스트</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="col-md-6">
							<div class="jumbotron">
								<h3 class="text-blue text-center">기존 사용자가 아니라면?</h3>
								<p>
									<span>회원 가입 진행 후 회원 로그인을 통해 모든 서비스를 이용하실 수 있습니다.</span> <span class="text-blue">지금 바로 회원가입을 진행해주세요!</span>
								</p><br/>
								<a class="btn btn-block btn-primary" href="./join/joinForm.do"><span class="glyphicon glyphicon-file"></span> 회원가입</a>
							</div>
						</div>
						<div class="col-md-6">
							<div class="jumbotron">
								<h3 class="text-blue text-center">기존 사용자라면?</h3>
								<p>
									<span>회원 로그인을 통해 모든 서비스를 이용하실 수 있습니다.</span> <br /> <span class="text-blue">지금 바로 회원 로그인을 진행해주세요!</span>
								</p><br/>
								<a class="btn btn-block btn-primary" href="./user/userLogin.do"><span class="glyphicon glyphicon-log-in"></span> 로그인</a>
							</div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!-- 입력 영역 -->
  </body>

</html>