<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="../js/common/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="../js/common/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/user/idSearch.js"></script>
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
		                        <span class="glyphicon glyphicon-search"></span> ID Search</h3>
		                </div>
		                <div class="panel-body">
		                    <div class="row">
								<form class="form" role="form" name="infoFrm" action="javascript:idSearch();">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-sm-2">
												<div>이메일</div>
												<div>
													<input type="text" class="form-control" placeholder="가입당시 이메일 주소를 입력해주세요." id="user_mail">
												</div>
											</div>
											<br/>
											<div class="col-sm-2">
												<button type="submit" class="btn btn-primary btn-lg btn-block"><span class="glyphicon glyphicon-ok"></span> 아이디 찾기</button>
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