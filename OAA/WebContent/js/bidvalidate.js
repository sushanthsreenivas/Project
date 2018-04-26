function bidCompare() {

	var lastbidamount = $("#lastBidAmount").val();
	var bidamount = $("#bidAmountIncrement").val();
	var increment = $("#bidAmount").val();

};

$(document).ready(function(){
	var lastbidamount = $("#lastBidAmount").val();
	var bidamount = $("#bidAmountIncrement").val();
	var increment = $("#bidAmount").val();
    $("submit").on("click", function(){
        var sum = lastbidamount +increment;
        if(sum<bidamount)
        	{
        	return true;
        	}
        else{
        	return false;       
        }
    })
})