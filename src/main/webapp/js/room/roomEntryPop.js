/**
 * 방입장
 */

var seq;

function setSeq(){
	seq = $("#seq").val();
}

function roomEntry() {
	var frm = document.roomFrm
	var room_master = frm.room_master.value;
	if (room_master == "") {
		alert("닉네임을 입력해주세요.");
	} else {
		chatEntry(room_master);
	}
};

function chatEntry(room_master) {
	opener.location.href="../chat/chatEntry.do?seq=" + seq + "&name=" + room_master;
	window.close();
}