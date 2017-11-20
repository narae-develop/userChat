/**
 * 리스트
 */

var sw = screen.availWidth;
var sh = screen.availHeight;
iw = 500;
ih = 400;
var wx = ( sw - iw ) / 2;
var wy = ( sh - ih - 45 ) / 2;

var setting = "toolbar=0,directories=0,status=no,menubar=0,scrollbars=auto,resizable=no,width=500,height=300,top="+wy+",left="+wx;

function addRoom() {
	var popup = window.open("../room/roomAddPop.do","_blank", setting);
}

function listSelect(_seq) {
	//var popup = window.open("../room/roomEntryPop.do?seq=" + _seq,"_blank", setting);
	location.href = "../chat/chatEntry.do?seq=" + _seq;
};