/**
 * 로그인
 */

var sw = screen.availWidth;
var sh = screen.availHeight;
iw = 500;
ih = 400;
var wx = ( sw - iw ) / 2;
var wy = ( sh - ih - 45 ) / 2;

var setting = "toolbar=0,directories=0,status=no,menubar=0,scrollbars=auto,resizable=no,width=500,height=300,top="+wy+",left="+wx;

function userLogin() {
	var frm = document.loginFrm
	var user_id = frm.user_id.value;
	var user_pwd = frm.user_pwd.value;

	if (user_id == "") {
		alert("아이디를 입력해주세요.");
	} else if (user_pwd == "") {
		alert("비밀번호를 입력해주세요.");
	} else {
		userLoginTest(user_id, user_pwd);
	}
};

function userLoginTest(user_id, user_pwd) {
	$.ajax({
		type : "POST",
		url : '../user/sessionLogin.ajax',
		data : {"id" : user_id, "pwd" : user_pwd},
		success : function(data) {
			if(!data.idCheck) {
				alert("가입된 아이디가 존재하지 않습니다.\n다시 한번 확인해주세요.");
				$("#user_id").val("");
			} else {
				if(!data.userCheck) {
					alert("비밀번호를 잘못 입력하셨습니다.\n다시 한번 확인해주세요.");
					$("#user_pwd").val("");
				} else {
					location.href="../";
				}
			}
		}
	});
}

function pwdValueChange(_val) {
	$("#randPwdText").hide();
}

function idSearch() {
	var popup = window.open("../user/idSearch.do","_blank", setting);
}

function pwdSearch() {
	var popup = window.open("../user/pwdSearch.do","_blank", setting);
}