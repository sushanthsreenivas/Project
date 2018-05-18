$(document).ready(function() {

	var lastbidamount = $("#last_bid").val();
	var bidamount = $("#cur_bid").val();
	var increment = $("#bid_inc").val();

	$("#cur_bid").keyup(function() {

		var sum = parseInt(lastbidamount) + parseInt(increment);

		if (parseInt(bidamount) >= parseInt(sum)) {
			   console.log('keypressd');
			$("#submit").removeAttr("disabled");

			return true;

		}else{
			$("#submit").attr("disabled");
		}

		//return false;

	});
});
