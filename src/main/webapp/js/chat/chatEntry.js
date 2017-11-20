/**
 * 채팅방
 */

var seq;
var id;
var name;
var listCnt = 0;
var timerCnt = 0;

function setTimer(){
	valueInit();
	roomExist();
}

function valueInit() {
	seq = $("#_seq").text();
	id = $("#_id").text();
	name = $("#_name").text();
	var objDiv = document.getElementById("chatBox");
	objDiv.scrollTop = objDiv.scrollHeight;
}

function roomExist() {
	if(seq==""){
		alert("채팅방이 존재하지 않습니다.\n이전 페이지로 돌아갑니다.");
		history.back(-1);
	} else {
		masterCheck();
		setInterval( ajaxCall, 3000 );
	}
}

function masterCheck() {
	$.ajax({
		type : "POST",
		url : '../room/masterCheck.ajax',
		data : {"seq" : seq, "id" : id},
		dataType : 'json',
		success : function(data) {
			if(!data.master) {
				$("#removeBtn").hide();
			} else {
				$("#removeBtn").show();
			}
		}
	});
}

function contentInsert() {
	var frm = document.chatFrm
	var content = frm.content.value;
	if (content == "") {
		alert("대화내용을 입력해주세요.");
	} else {
		ajaxNetwork(content);
	}
};

function ajaxCall(){
	$.ajax({
		type : "POST",
		url : '../chat/chatList.ajax',
		data : {"seq" : seq},
		dataType : 'json',
		success : function(data) {
			
			if(!data.pageBack) {
				var dataLen = data.chatList.length;
				listCnt = dataLen;
	
				var dataText = "";
					dataText += "<ul class=\"chatbox\">";
				for(var i=0; i<dataLen; i++) {
					dataText += "<li class=\"blue list-group-item\">";
					dataText += "<span class=\"text-primary\">" + data.chatList[i].user_name + "</span> : ";
					dataText += "<span class=\"text-gray\">" + data.chatList[i].content + "</span>";
					dataText += "<p class=\"text-right list-date\">" + data.chatList[i].date + "</p></li>";
				}
				dataText += "</ul>";
				$("#ajaxChatList").html(dataText);
				$("#chatBox").scrollTop = $("#chatBox").scrollHeight;
			} else {
				alert("채팅방이 종료되었습니다.\n이전 페이지로 돌아갑니다.");
				history.back(-1);
			}
		}
	});
	//채팅 내용이 새로 들어올 시에만 스크롤 하단으로 내릴 것
	if(listCnt > timerCnt) {
		var objDiv = document.getElementById("chatBox");
		objDiv.scrollTop = objDiv.scrollHeight;
		timerCnt = listCnt;
	}
	
}

function ajaxNetwork(content) {
	$.ajax({
		type : "POST",
		url : '../chat/chatInsert.ajax',
		data : {"seq" : seq, "id" : id, "name" : name, "content" : content},
		dataType : 'json',
		success : function(data) {
			if(!data.pageBack) {
				$("#content").val("");
				var dataLen = data.chatList.length;
				listCnt = dataLen;
				var dataText = "";
					dataText += "<ul class=\"chatbox\">";
				for(var i=0; i<dataLen; i++) {
					dataText += "<li class=\"blue list-group-item\">";
					dataText += "<span class=\"text-primary\">" + data.chatList[i].user_name + "</span> : ";
					dataText += "<span class=\"text-gray\">" + data.chatList[i].content + "</span>";
					dataText += "<p class=\"text-right list-date\">" + data.chatList[i].date + "</p></li>";
				}
				dataText += "</ul>";
				$("#ajaxChatList").html(dataText);
			} else {
				alert("채팅방이 종료되었습니다.\n이전 페이지로 돌아갑니다.");
				history.back(-1);
			}
		}
	});
}

function removeRoom() {
	$.ajax({
		type : "POST",
		url : '../room/removeRoom.ajax',
		data : {"seq" : seq, "id" : id},
		dataType : 'json',
		success : function(data) {
			alert("채팅방이 정상적으로 삭제되었습니다.\n이전 페이지로 돌아갑니다.");
			history.back(-1);
		}
	});
}