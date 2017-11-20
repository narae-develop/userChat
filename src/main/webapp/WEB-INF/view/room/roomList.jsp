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
    <script type="text/javascript" src="../js/room/roomList.js"></script>
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
            <li class="active">
              <a href="#" onclick="roomList();"><span class="glyphicon glyphicon-tasks"></span> Room List</a>
            </li>
            <li>
              <a href="#" onclick="myInfo();"><span class="glyphicon glyphicon-user"></span> My Info</a>
            </li>
            <li>
    		  <a href="#" onclick="sessionLogout();"><span class="glyphicon glyphicon-off"></span> Logout</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <!-- 게시판 영역 -->
    <div class="section">
      <div class="container">
      <div class="row">
         <div class="col-md-12">
           <div class="page-header">
              <h2>채팅
                <small>리스트</small>
              </h2>
            </div>
         </div>
       </div>
      <div class="row text-right">
         <div class="col-md-12">
           <a class="btn btn-primary" onclick="addRoom()">방 개설</a>
         </div>
       </div><p>
		<!-- 테이블영역 -->
        <div class="row">
          <div class="col-md-12">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th class="info" style="width:15%;">방장</th>
                  <th class="info" style="width:70%;">방제목</th>
                  <th class="info" style="width:15%;">개설일자</th>
                </tr>
              </thead>
              <tbody>
              <c:choose>
					<c:when test="${empty roomList}">
						<ul class="list-group text-muted">
							<tr>
			                  <td colspan=4>개설된 채팅방이 없습니다.</td>
			                </tr>
						</ul>
					</c:when>
					<c:otherwise>
						<c:forEach var="room" items="${roomList}">
			                <tr onClick="listSelect(${room.seq});">
			                  <td>${room.master_name}</td>
			                  <td style="text-align:left; padding-left:25%;">${room.room_title}</td>
			                  <td>${room.date}</td>
			                </tr>
		                </c:forEach>
					</c:otherwise>
				</c:choose>
              </tbody>
            </table>
          </div>
        </div>
        <!-- 페이징 -->
        <div class="row">
          <div class="col-md-12 text-center">
            <ul class="pagination">
              <c:choose>
					<c:when test="${preBtn eq true}">
						<li><a href="roomList.do?pageNum=${startPageNum-1}">Pre</a></li>
					</c:when>
				</c:choose>
            <c:forEach var="counter" begin="${startPageNum}" end="${endPageNum}">
            	<c:choose>
					<c:when test="${currentPage eq counter}">
						<li class="active"><a href="roomList.do?pageNum=${counter}"><c:out value="${counter}"/></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="roomList.do?pageNum=${counter}"><c:out value="${counter}"/></a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${nextBtn eq true}">
					<li><a href="roomList.do?pageNum=${endPageNum+1}">Next</a></li>
				</c:when>
			</c:choose>
            </ul>
          </div>
        </div>
      </div>
    </div>
</body>

</html>