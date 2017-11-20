/**
 * 방입장
 */

function idSearch() {
	var frm = document.infoFrm
	var user_mail = frm.user_mail.value;
	if (user_mail == "") {
		alert("가입당시 이메일을 입력해주세요.");
	} else {
		searchResult(user_mail);
	}
};

function searchResult(user_mail) {
	$.ajax({
		type : "POST",
		url : '../user/idSearchResult.ajax',
		data : {"user_mail" : user_mail},
		success : function(data) {
			if(data.userId == null) {
				alert("가입된 아이디가 존재하지 않습니다.\n다시 한번 확인해주세요.");
			} else {
				alert("현재 \"" + data.userId + "\" 아이디가 존재합니다.");
				opener.document.loginFrm.user_id.value = data.userId;
				window.close();
			}
		}
	});
}