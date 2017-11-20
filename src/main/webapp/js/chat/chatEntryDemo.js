/**
 * 데모버전
 */

var seq;
var name;
var listCnt = 0;
var timerCnt = 0;

function setTimer(){
	$.ajax({
		type : "POST",
		url : '../chat/chatList.ajax',
		data : {"seq" : seq },
		dataType : 'json',
		success : function(data) {
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
		}
	});
	initFunction();
}

function initFunction() {
	seq = 1;
	var objDiv = document.getElementById("chatBox");
	objDiv.scrollTop = objDiv.scrollHeight;
	setInterval( ajaxCall, 3000 );
}

function contentInsert() {
	var frm = document.chatFrm
		name = frm.name.value;
	var content = frm.content.value;
	if (name == "") {
		alert("닉네임을 입력해주세요.");
	} else if (content == "") {
		alert("대화내용을 입력해주세요.");
	} else {
		ajaxNetwork(content);
	}
};

function ajaxCall(){
	$.ajax({
		type : "POST",
		url : '../chat/chatList.ajax',
		data : {"seq" : seq },
		dataType : 'json',
		success : function(data) {
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
		data : {"seq" : seq, "name" : name, "content" : content},
		dataType : 'json',
		success : function(data) {
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
		}
	});
}