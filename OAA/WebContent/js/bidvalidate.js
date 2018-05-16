$(document).ready(function() {

	var lastbidamount = $("#last_bid").val();
	var bidamount = $("#cur_bid").val();
	var increment = $("#bid_inc").val();

	$("#cur_bid").mouseleave(function() {
		location.reload();
		var sum = parseInt(lastbidamount) + parseInt(increment);
		if (parseInt(bidamount) > parseInt(sum)) {

			$("#submit").attr("disabled", false);
			return true;
		}
		return false;

	});

});