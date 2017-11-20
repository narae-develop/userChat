<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="../js/common/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="../js/common/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/room/roomAddPop.js"></script>
	<link href="../css/common.css" rel="stylesheet" type="text/css">
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="section">
		<div class="container">
			<p>
		    <div class="row">
		        <div class="col-md-6">
		            <div class="panel panel-primary">
		                <div class="panel-heading">
		                    <h3 class="panel-title text-center">
		                        <span class="glyphicon glyphicon-cog"></span> Chat Room Add</h3>
		                </div>
		                <div class="panel-body">
		                    <div class="row">
								<form class="form" role="form" name="roomFrm" action="javascript:roomInsert();">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-sm-8">
												<div>채팅방 제목</div>
												<div>
													<input type="text" class="form-control" placeholder="채팅방 제목을 입력하세요" id="room_title">
												</div>
												<c:forEach var="loginInfo" items="${sessionScope.loginInfo}">
								                	<div id="user_id" style="display:none">${loginInfo.user_id}</div>
								                	<div id="user_name" style="display:none">${loginInfo.user_name}</div>
								                </c:forEach>
											</div><br/>
											<div class="col-sm-2">
												<button type="submit" class="btn btn-primary btn-lg btn-block"><span class="glyphicon glyphicon-ok"></span> 방 개설</button>
											</div>
										</div>
									</div>
									</form>
								</div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
</body>
</html>