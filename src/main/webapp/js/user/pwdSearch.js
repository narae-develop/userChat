/**
 * 방입장
 */

function valueInit() {
	var parentFrm = opener.document.loginFrm;
	var childFrm = document.infoFrm;
	
	var parentId = parentFrm.user_id.value;
	var childId = childFrm.user_id;

	if(parentId == null || parentId == "") {
		childId.value = "";
	} else {
		childId.value = parentId;
	}
}

function pwdSearch() {
	var frm = document.infoFrm
	var user_id = frm.user_id.value;
	if (user_id == "") {
		alert("아이디를 입력해주세요.");
	} else {
		searchResult(user_id);
	}
};

function searchResult(user_id) {
	$.ajax({
		type : "POST",
		url : '../user/pwdSearchResult.ajax',
		data : {"user_id" : user_id},
		success : function(data) {
			if(data.userPwd == null) {
				alert("가입된 아이디가 존재하지 않습니다.\n다시 한번 확인해주세요.");
			} else {
				alert("현재 변경된 임시 비밀번호는 \"" + data.userPwd + "\" 입니다.\n로그인 후에 내정보에서 비밀번호를 수정해주세요.");
				opener.document.loginFrm.user_pwd.value = data.userPwd;
				opener.document.getElementById("randPwdText").innerHTML = "현재 변경된 임시 비밀번호는 \"" + data.userPwd + "\" 입니다. 로그인 후에 내정보에서 비밀번호를 수정해주세요.";
				opener.document.getElementById("randPwdText").style.display = "block";
				window.close();
			}
		}
	});
}