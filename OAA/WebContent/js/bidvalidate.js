$(document).ready(function() {

	var lastbidamount = $("#last_bid").val();
	var bidamount = $("#cur_bid").val();
	var increment = $("#bid_inc").val();

	$("#cur_bid").blur(function() {

		var sum = parseInt(lastbidamount) + parseInt(increment);
		if (parseInt(bidamount) > parseInt(sum)) {
			location.reload();
			$("#submit").attr("disabled", false);

			return true;
		}
		return false;

	});

});