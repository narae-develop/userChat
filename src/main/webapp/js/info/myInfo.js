/**
 * 회원정보
 */

var nameVal;
var mailVal;
var nameDupl = true;
var mailDupl = true;

function valueInit() {
	nameVal = $("#_name").text();
	mailVal = $("#_mail").text();
}

function userJoin() {
	var frm = document.joinFrm
	var user_id = frm.user_id.value;
	var user_name = frm.user_name.value;
	var user_mail = frm.user_mail.value;
	
	if(validationCheck(user_id, user_name, user_mail)){
		userModifyAjax(user_id, user_name, user_mail);
	}
};

function validationCheck(user_id, user_name, user_mail) {
	if (user_id == "") {
		alert("아이디를 입력해주세요.");
		return false;
	} else if (user_name == "") {
		alert("닉네임을 입력해주세요.");
		return false;
	} else if (user_mail == "") {
		alert("이메일을 입력해주세요.");
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
				if(compareValue(_type, _val)) {
					duplChange(_type, true);
					$("#" + _type + "Text").hide();
				} else {
					typeText = typeTextChange(_type, 1);
					duplChange(_type, false);
					$("#" + _type + "Text").show();
					$("#" + _type + "Text").html(typeText + " 중복됩니다. 재입력해주세요.");
				}
			} else {
				typeText = typeTextChange(_type, 2);
				if($("#user_" + _type).val() == "" || $("#user_" + _type).val() == null) {
					duplChange(_type, false);
					$("#" + _type + "Text").show();
					$("#" + _type + "Text").html(typeText + " 재입력해주세요.");
				} else {
					duplChange(_type, true);
					$("#" + _type + "Text").show();
					$("#" + _type + "Text").html("사용하셔도 됩니다.");
				}
			}
		}
	});
}

function compareValue(_type, _val) {
	if(_type == "name") {
		if(nameVal == _val) {
			return true;
		} else {
			return false;
		}
	} else {
		if(mailVal == _val) {
			return true;
		} else {
			return false;
		}
	}
}

function duplChange(_type, _bool) {
	if(_type == "name") {
		nameDupl = _bool;
	} else {
		mailDupl = _bool;
	}
}

function typeTextChange(_type, _ver) {
	if(_ver == 1) {
		if(_type == "name") {
			return typeText = "닉네임이";
		} else {
			return typeText = "이메일이";
		}
	} else {
		if(_type == "name") {
			return typeText = "닉네임을";
		} else {
			return typeText = "이메일을";
		}
	}
}

function userModifyAjax(user_id, user_name, user_mail) {
	$.ajax({
		type : "POST",
		url : '../info/userUpdate.ajax',
		data : {"id" : user_id, "name" : user_name, "mail" : user_mail},
		dataType : 'json',
		success : function(data) {
			alert("내정보가 수정되었습니다.");
			location.href = "../info/myInfo.do";
		}
	});
}

function pwdChange() {
	var sw = screen.availWidth;
	var sh = screen.availHeight;
	iw = 500;
	ih = 400;
	var wx = ( sw - iw ) / 2;
	var wy = ( sh - ih - 45 ) / 2;

	var setting = "toolbar=0,directories=0,status=no,menubar=0,scrollbars=auto,resizable=no,width=500,height=400,top="+wy+",left="+wx;
	var popup = window.open("../user/pwdChange.do","_blank", setting);
}