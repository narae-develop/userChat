/**
 * 중복체크
 */

var uniqueVal = "";
var pageType = "";

function duplicationCheck() {
	var frm = document.chkFrm
	var type = frm.type.value;
	
	pageType = type;
	
	if(type=="ID") { //ID 중복체크일 시
		var user_id = frm.user_id.value;
		if (user_id == "") {
			alert("아이디를 입력해주세요.");
		} else {
			idCheck(user_id);
		}
	} else { //닉네임 중복체크일 시
		var user_name = frm.user_name.value;
		if (user_name == "") {
			alert("닉네임을 입력해주세요.");
		} else {
			nameCheck(user_name);
		}
	}

};

function idCheck(user_id) {
	$.ajax({
		type : "POST",
		url : '../join/idCount.ajax',
		data : {"user_id" : user_id},
		success : function(data) {
			if(data.idCount) {
				alert("중복된 아이디가 있습니다.\n다시 확인해주세요.")
				$("#user_id").val("");
			} else {
				alert("아이디 사용 가능합니다.");
				uniqueVal = user_id;
				$("#checkBtn").hide();
				$("#useBtn").show();
			}
		}
	});
}

function nameCheck(user_name) {
	$.ajax({
		type : "POST",
		url : '../join/nameCount.ajax',
		data : {"user_name" : user_name},
		success : function(data) {
			if(data.nameCount) {
				alert("중복된 닉네임이 있습니다.\n다시 확인해주세요.")
				$("#user_name").val("");
			} else {
				alert("닉네임 사용 가능합니다.");
				uniqueVal = user_name;
				$("#checkBtn").hide();
				$("#useBtn").show();
			}
		}
	});
}

function valueChange(_type, value) {
	$("#checkBtn").show();
	$("#useBtn").hide();
}

function useUnique() {
	if(pageType == "ID") {
		opener.document.joinFrm.user_id.value=uniqueVal;
		window.close();
	} else {
		opener.document.joinFrm.user_name.value=uniqueVal;
		window.close();
	}
}