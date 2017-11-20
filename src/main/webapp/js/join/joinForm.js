/**
 * 회원가입
 */

var idDupl = false;
var nameDupl = false;
var mailDupl = false;

function userJoin() {
	var frm = document.joinFrm
	var user_id = frm.user_id.value;
	var user_name = frm.user_name.value;
	var user_pwd = frm.user_pwd.value;
	var user_mail = frm.user_mail.value;
	var user_pwd_ok = frm.user_pwd_ok.value;
	
	if(validationCheck(user_id, user_name, user_mail, user_pwd, user_pwd_ok)){
		userJoinAjax(user_id, user_name, user_mail, user_pwd);
	}
};

function validationCheck(user_id, user_name, user_mail, user_pwd, user_pwd_ok) {
	if (user_id == "") {
		alert("아이디를 입력해주세요.");
		return false;
	} else if (user_name == "") {
		alert("닉네임을 입력해주세요.");
		return false;
	} else if (user_mail == "") {
		alert("이메일을 입력해주세요.");
		return false;
	} else if (user_pwd == "") {
		alert("비밀번호를 입력해주세요.");
		return false;
	} else if (user_pwd_ok == "") {
		alert("비밀번호 확인을 입력해주세요.");
		return false;
	} else if (user_pwd !== user_pwd_ok) {
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		return false;
	} else if (idDupl == false) {
		alert("아이디를 중복되지 않게 입력해주세요.");
		return false;
	} else if (nameDupl == false) {
		alert("닉네임을 중복되지 않게 입력해주세요.");
		return false;
	} else if (mailDupl == false) {
		alert("이메일을 중복되지 않게 입력해주세요.");
		return false;
	} else {
		return true;
	}
}

function valueChange(_type, _val) {
	var dataVal = "{\"user_" + _type + "\" : \"" + _val + "\"}";
	var dataJson = JSON.parse(dataVal);
	var typeText;

	$.ajax({
		type : "POST",
		url : '../join/' + _type + 'Count.ajax',
		data : dataJson,
		success : function(data) {
			if(data.count) {
				typeText = typeTextChange(_type, 1);
				duplChange(_type, false);
				$("#" + _type + "Text").html(typeText + " 중복됩니다. 재입력해주세요.");
			} else {
				typeText = typeTextChange(_type, 2);
				if($("#user_" + _type).val() == "" || $("#user_" + _type).val() == null) {
					duplChange(_type, false);
					$("#" + _type + "Text").html(typeText + " 재입력해주세요.");
				} else {
					duplChange(_type, true);
					$("#" + _type + "Text").html("사용하셔도 됩니다.");
				}
			}
		}
	});
}

function duplChange(_type, _bool) {
	if(_type == "id") {
		idDupl = _bool;
	} else if(_type == "name") {
		nameDupl = _bool;
	} else {
		mailDupl = _bool;
	}
}

function typeTextChange(_type, _ver) {
	if(_ver == 1) {
		if(_type == "id") {
			return typeText = "아이디가";
		} else if(_type == "name") {
			return typeText = "닉네임이";
		} else {
			return typeText = "이메일이";
		}
	} else {
		if(_type == "id") {
			return typeText = "아이디를";
		} else if(_type == "name") {
			return typeText = "닉네임을";
		} else {
			return typeText = "이메일을";
		}
	}
}

function userJoinAjax(user_id, user_name, user_mail, user_pwd) {
	$.ajax({
		type : "POST",
		url : '../join/userInsert.ajax',
		data : {"id" : user_id, "name" : user_name, "mail" : user_mail, "pwd" : user_pwd},
		dataType : 'json',
		success : function(data) {
			location.href = "../join/joinComplete.do";
		}
	});
}

function duplicationCheck(_type) {
	var sw = screen.availWidth;
	var sh = screen.availHeight;
	iw = 500;
	ih = 400;
	var wx = ( sw - iw ) / 2;
	var wy = ( sh - ih - 45 ) / 2;

	var setting = "toolbar=0,directories=0,status=no,menubar=0,scrollbars=auto,resizable=no,width=500,height=300,top="+wy+",left="+wx;
	var popup = window.open("../join/duplicationCheck.do?type=" + _type,"_blank", setting);
}