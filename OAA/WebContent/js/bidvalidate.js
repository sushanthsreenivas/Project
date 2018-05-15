$(document).ready(function() {
	var lastbidamount = $("#last_bid").val();
	var bidamount = $("#cur_bid").val();
	var increment = $("#bid_inc").val();
	$("#submit").submit(function() {
		var sum = parseInt(lastbidamount) + parseInt(increment);

		if (parseInt(bidamount) > parseInt(sum)) {
			alert(bidamount);
			
			return true;
		}
		return false;

	});
	
});