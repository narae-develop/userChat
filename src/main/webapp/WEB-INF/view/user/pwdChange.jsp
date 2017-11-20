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
    <script type="text/javascript" src="../js/user/pwdChange.js"></script>
	<link href="../css/common.css" rel="stylesheet" type="text/css">
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body onload="valueInit();">
	<div class="section">
		<div class="container">
			<p>
		    <div class="row">
		        <div class="col-md-6">
		            <div class="panel panel-primary">
		                <div class="panel-heading">
		                    <h3 class="panel-title text-center">
		                        <span class="glyphicon glyphicon-cog"></span> Password Change</h3>
		                </div>
		                <div class="panel-body">
		                    <div class="row">
								<form class="form" role="form" name="infoFrm" action="javascript:pwdChange();">
									<div class="col-md-12">
										<div class="form-group">
											<c:forEach var="loginInfo" items="${sessionScope.loginInfo}">
							               		<div id="_id" style="display:none">${loginInfo.user_id}</div>
							                </c:forEach>
											<div class="col-sm-12">
												<div>기존 비밀번호</div>
												<div>
													<input type="password" class="form-control" placeholder="기존 비밀번호를 입력해주세요." id="old_pwd">
												</div>
											</div>
											<br/>
											<div class="col-sm-12">
												<div>신규 비밀번호</div>
												<div>
													<input type="password" class="form-control" placeholder="신규 비밀번호를 입력해주세요." id="new_pwd">
												</div>
											</div>
											<br/>
											<div class="col-sm-12">
												<div>신규 비밀번호 확인</div>
												<div>
													<input type="password" class="form-control" placeholder="신규 비밀번호를 한번 더 입력해주세요." id="new_pwd_ok">
												</div>
											</div>
											<br/>
											<div class="col-sm-12">
												<button type="submit" class="btn btn-primary btn-lg btn-block"><span class="glyphicon glyphicon-ok"></span> 비밀번호 변경</button>
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
	</div>
</body>
</html>