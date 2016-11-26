"use strict";

var summonerPictureDiv = '<div class="playerBox"><div class="playerPicture"><img src="[SUMMONER_IMAGE]"/></div>[SUMMONER_NAME]</div>';

var app = (function() {
	var debug= false;
	var imageBase = "http://cdn.leagueofgraphs.com/img/summonerIcons/6.23.1/36/"; /* "http://cdn.leagueofgraphs.com/img/summonerIcons/6.23.1/36/1419.png" */
	var callData;
	var callStatus;
	var blueParticipants = [];
	var redParticipants = [];
	
	
	function setText(elementSelector, textValue)
	{
		$(elementSelector).text(textValue);
	}
	
	function setDate(elementSelector, dateValue)
	{
		var date =  new Date(dateValue)
		$(elementSelector).text(date.toLocaleString());
	}
	
	function getPlayerBox(playerName, imageId)
	{
		var newDiv = summonerPictureDiv.replace("[SUMMONER_IMAGE]", imageBase + imageId + ".png");
		newDiv = newDiv.replace("[SUMMONER_NAME]", playerName);
		return newDiv;
	}
	
	function saveParticipants(match)
	{
		blueParticipants = [];
		redParticipants = [];
		
		for (var i =0; i < match.participantIdentities.length; i++) {
			if(match.participants[i].teamId==100)
			{
				blueParticipants.push(match.participantIdentities[i]);
			}
			else
			{
				redParticipants.push(match.participantIdentities[i]);
			}
		}
	}
	
	function setBlueTeam()
	{
		setParticipants("#teamBlueElements", blueParticipants);	
	}
	
	function setReadTeam()
	{
		setParticipants("#teamRedElements", redParticipants);	
	}
	
	function setParticipants(elementSelector, participants){
		var participantsText ="";
		
		for (var currParticipant of participants) { 
			participantsText += getPlayerBox(currParticipant.player.summonerName, currParticipant.player.profileIcon);
		}
		$(elementSelector).html(participantsText);
	}
	
	function showData(data, status) {
		callData = data;
		callStatus = status;
		
		if(callData.currentGameInfo.gameId != 0)
		{
			setText("#gameId", callData.currentGameInfo.gameId);
			setDate("#gameDate",callData.currentGameInfo.gameStartTime);
			saveParticipants(callData.currentGameInfo);
			setBlueTeam();
			setReadTeam();
		}
		else if(callData.matches.length  > 0) //No current game data, use first match:
		{
			var currMatch = callData.matches[0];
			setText("#gameId", currMatch.matchId);
			setDate("#gameDate", currMatch.matchCreation);
			saveParticipants(currMatch);
			setBlueTeam();
			setReadTeam();
		}
		else
		{
			setText("#gameId","No match found");
		}
		setText("#summonerName",callData.summoner.name);
		setText("#summonerID",callData.summoner.id);
		setText("#summonerMatchNumber",callData.totalGames);
		setText("#summonerLevel",callData.summoner.summonerLevel);
		$("#summonerImage").attr("src", imageBase + callData.summoner.profileIconId + ".png");
		//$(".matches").text("data:" + JSON.stringify(callData));
		
	}
  
  return {
    setData: function(data, text) {
      showData(data, text);
    },
	showMatchView: function(){
		//$("#firstView").hide();
		app.clearErrors();
		app.clearInfo();
		$("#matchView").show();
	},
	clearErrors: function()
	{
		$(".error").text("");
	},
	showError: function(textError)
	{
		$(".error").html(textError);
	},
	clearInfo: function()
	{
		$("#loadingInfo").text("");
	},
	searchSummonerGames: function()
	{
		//Remove white spaces.
		var summonerName = $(".searchSummonerTextBox").val().replace(/\s+/g, '');
		summonerName = summonerName.toLowerCase();
		
		if(summonerName == "")
		{
			app.showMatchView();
			app.showError("Please fill in Summoner name");
			return;
		}

			$(".matches").hide();
			app.showMatchView();	
			$("#loadingInfo").text("Loading");
			
			var apiUrl = "http://176.58.126.231:8090/app/lol/" + $(".searchRegionSelect").val() + "/summoner/" + summonerName + "/matches";
				console.log("Calling:" + apiUrl);
			if(debug == true)
			{
				apiUrl =  "http://web.ist.utl.pt/ist153813/lol/fake.json";
			}			
			var summonerRequest = $.ajax({
				url : apiUrl,
				dataType : "json",
				timeout : 40000
			});

			summonerRequest.success(function(data, status) {
				app.showMatchView();
				$(".matches").show();
				app.setData(data, status);
			});
			summonerRequest.error(function(response, type, serverReply) {
				app.showMatchView();
				app.showError("Error fetching page: " + apiUrl + "<br>" + serverReply + " " + response.status +  ":" + response.responseText);
				console.log("Error:" + response.status + ":" + response.responseText);
			});		
	}
  };   
})();

$(function() {

	//Get the parameters:
	$(".searchSummonerTextBox").val($.urlParam('summoner'));
	var region = $.urlParam('region');
	if(region != null)
	{
		region = region.toUpperCase();
	}
	$(".searchRegionSelect").val(region);
	
	if($(".searchSummonerTextBox").val() != null && $(".searchSummonerTextBox").val() != "" && region == $(".searchRegionSelect").val())
	{
		app.searchSummonerGames();
	}

	$("#searchSummonerButtom").click(function(){
		app.searchSummonerGames();
	});
	
});

$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null){
       return null;
    }
    else{
       return results[1] || 0;
    }
}