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
    <script type="text/javascript" src="../js/chat/chatEntryDemo.js"></script>
	<link href="../css/common.css" rel="stylesheet" type="text/css">
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
  </head>
  
  <body onload="setTimer();">
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
              <!-- a href="roomList.do?pageNum=1">Chatting</a -->
            </li>
          </ul>
        </div>
      </div>
    </div>
    <!-- 게시판 영역 -->
    <div class="section">
      <div class="container">
      		<!-- 테이블 영역 -->
	        <div class="row">
	          <div class="col-md-12">
	            <table class="table">
	              <thead>
	                <tr>
	                	<th class="info">채팅기능 제공</th>
	                </tr>
	              </thead>

	            </table>
	          </div>
	        </div>
	        <!-- 채팅 영역 -->
	        <div class="row">
	          <div class="col-md-12">
	              <div style="width:100%; height:300px; overflow:auto;" id="chatBox">
	              	<!-- 채팅 리스트 Start -->
	              	<div id="ajaxChatList">
	            		<c:choose>
							<c:when test="${not empty chatList}">
								<ul class="chatbox">
									<c:forEach var="chatList" items="${chatList}">
				                    	<li class="blue list-group-item">
						              		<span class="text-primary">${chatList.user_name}</span> : <span class="text-gray">${chatList.content}</span>
						              		<p class="text-right list-date">${chatList.date}</p>
						              	</li>
				                    </c:forEach>
				              	</ul>
							</c:when>
						</c:choose>
					</div>
	              	<!-- 채팅 리스트 End -->
	              </div>
	          </div>
	        </div>
	        <br/>
	        <!-- 코멘트 입력 -->
		        <div class="row">
		          <div class="col-md-12">
		            <div class="alert alert-dismissable alert-gray">
		            	<form role="form" name="chatFrm" action="javascript:contentInsert();">
			              <div class="form-group">
			              	<div class="input-group">대화내용 입력<br />
			              		<input type="text" class="form-control" placeholder="닉네임 입력" id="name">
			              	</div>
			                <div class="input-group">
			                  <input type="text" class="form-control" placeholder="대화내용을 입력해주세요." id="content">
			                  <span class="input-group-btn">
			                    <button type="submit" class="btn btn-primary">입력</button>
			                  </span>
			                </div>
			              </div>
			            </form>
		            </div>
		          </div>
		        </div>
	        
		</div>
    </div>
</body>

</html>