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
    <script type="text/javascript" src="../js/join/duplicationCheck.js"></script>
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
		                    <h3 class="panel-title text-center"><span class="glyphicon glyphicon-user"></span> ${type} Duplication</h3>
		                </div>
		                <div class="panel-body">
		                    <div class="row">
								<form class="form" role="form" name="chkFrm" action="javascript:duplicationCheck();">
									<input type="hidden" value="${type}" id="type">
									<div class="col-md-12">
										<div class="form-group">
											<c:choose>
												<c:when test="${'ID' eq type}">
												<div class="col-sm-2">
													<div>아이디</div>
													<div>
														<input type="text" class="form-control" placeholder="아이디를 입력하세요" id="user_id" onchange="valueChange('id', this.value);">
													</div>
												</div>
												</c:when>
												<c:otherwise>
													<div class="col-sm-2">
														<div>닉네임</div>
														<div>
															<input type="text" class="form-control" placeholder="닉네임을 입력하세요" id="user_name" onchange="valueChange('name', this.value);">
														</div>
													</div>
												</c:otherwise>
											</c:choose>
											<br/>
											<div class="col-sm-2">
												<button type="submit" class="btn btn-primary btn-lg btn-block" id="checkBtn"><span class="glyphicon glyphicon-check"></span> 중복체크</button>
												<a class="btn btn-primary btn-lg btn-block" id="useBtn" style="display:none;" onclick="useUnique();"><span class="glyphicon glyphicon-pencil"></span> 사용하기</a>
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