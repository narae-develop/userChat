/**
 * 방개설
 */

function roomInsert() {
	var frm = document.roomFrm
	var master_id = $("#user_id").text();
	var master_name = $("#user_name").text();
	var room_title = frm.room_title.value;
	if (room_title == "") {
		alert("방제목을 입력해주세요.");
	} else {
		ajaxNetwork(room_title, master_id, master_name);
	}
};

function ajaxNetwork(room_title, master_id, master_name) {
	
	$.ajax({
		type : "POST",
		url : '../room/roomAdd.ajax',
		data : {"room_title" : room_title, "master_id" : master_id, "master_name" : master_name},
		success : function(data) {
			opener.location.href="../chat/chatEntry.do?seq=" + data.roomInfo[0].seq;
			window.close();
		}
	});

}