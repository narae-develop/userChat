/**
 * 방입장
 */

var user_id;

function valueInit() {
	user_id = $("#_id").text();
}

function pwdChange() {
	var frm = document.infoFrm
	var old_pwd = frm.old_pwd.value;
	var new_pwd = frm.new_pwd.value;
	var new_pwd_ok = frm.new_pwd_ok.value;

	if(validationCheck(old_pwd, new_pwd, new_pwd_ok)){
		pwdChangeResult(user_id, old_pwd, new_pwd);
	}
};

function validationCheck(old_pwd, new_pwd, new_pwd_ok) {
	if (old_pwd == "") {
		alert("기존 비밀번호를 입력해주세요.");
		return false;
	} else if (new_pwd == "") {
		alert("신규 비밀번호를 입력해주세요.");
		return false;
	} else if (new_pwd_ok == "") {
		alert("신규 비밀번호 확인을 입력해주세요.");
		return false;
	} else if (old_pwd == new_pwd) {
		alert("신규 비밀번호는 기존 비밀번호와 다르게 입력하셔야 합니다.");
		return false;
	} else if (new_pwd !== new_pwd_ok) {
		alert("신규 비밀번호와 신규 비밀번호 확인이 일치하지 않습니다.");
		return false;
	} else {
		return true;
	}
}

function pwdChangeResult(user_id, old_pwd, new_pwd) {
	$.ajax({
		type : "POST",
		url : '../user/pwdChangeResult.ajax',
		data : {"user_id" : user_id, "old_pwd" : old_pwd, "new_pwd" : new_pwd},
		success : function(data) {
			if(data.missPwd) {
				alert("기존 비밀번호를 다시 입력해주세요.");
			} else {
				alert("비밀번호 변경을 정상적으로 완료하였습니다.");
				window.close();
			}
		}
	});
}