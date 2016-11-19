package main.riot.domain.game;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-19.
 */
public class RawStatsDto {

    @JsonProperty
    private int assists;
    @JsonProperty
    private int barracksKilled;
    @JsonProperty
    private int bountyLevel;
    @JsonProperty
    private int championsKilled;
    @JsonProperty
    private int combatPlayerScore;
    @JsonProperty
    private int consumablesPurchased;
    @JsonProperty
    private int damageDealtPlayer;
    @JsonProperty
    private int doubleKills;
    @JsonProperty
    private int firstBlood;
    @JsonProperty
    private int gold;
    @JsonProperty
    private int goldEarned;
    @JsonProperty
    private int goldSpent;
    @JsonProperty
    private int item0;
    @JsonProperty
    private int item1;
    @JsonProperty
    private int item2;
    @JsonProperty
    private int item3;
    @JsonProperty
    private int item4;
    @JsonProperty
    private int item5;
    @JsonProperty
    private int item6;
    @JsonProperty
    private int itemsPurchased;
    @JsonProperty
    private int killingSprees;
    @JsonProperty
    private int largestKillingSpree;
    @JsonProperty
    private int largestCriticalStrike;
    @JsonProperty
    private int largestMultiKill;
    @JsonProperty
    private int legendaryItemsCreated;
    @JsonProperty
    private int level;
    @JsonProperty
    private int magicDamageDealtPlayer;
    @JsonProperty
    private int magicDamageDealtToChampions;
    @JsonProperty
    private int magicDamageTaken;
    @JsonProperty
    private int minionsDenied;
    @JsonProperty
    private int minionsKilled;
    @JsonProperty
    private int neutralMinionsKilled;
    @JsonProperty
    private int neutralMinionsKilledEnemyJungle;
    @JsonProperty
    private int neutralMinionsKilledYourJungle;
    @JsonProperty
    private int nexusKilled;
    @JsonProperty
    private int nodeCapture;
    @JsonProperty
    private int nodeCaptureAssist;
    @JsonProperty
    private int nodeNeutralize;
    @JsonProperty
    private int nodeNeutralizeAssist;
    @JsonProperty
    private int numDeaths;
    @JsonProperty
    private int numItemsBought;
    @JsonProperty
    private int objectivePlayerScore;
    @JsonProperty
    private int pentaKills;
    @JsonProperty
    private int physicalDamageDealtPlayer;
    @JsonProperty
    private int physicalDamageDealtToChampions;
    @JsonProperty
    private int physicalDamageTaken;
    @JsonProperty
    private int playerPosition;
    @JsonProperty
    private int playerRole;
    @JsonProperty
    private int playerScore0;
    @JsonProperty
    private int playerScore1;
    @JsonProperty
    private int playerScore2;
    @JsonProperty
    private int playerScore3;
    @JsonProperty
    private int playerScore4;
    @JsonProperty
    private int playerScore5;
    @JsonProperty
    private int playerScore6;
    @JsonProperty
    private int playerScore7;
    @JsonProperty
    private int playerScore8;
    @JsonProperty
    private int playerScore9;
    @JsonProperty
    private int quadraKills;
    @JsonProperty
    private int sightWardsBought;
    @JsonProperty
    private int spell1Cast;
    @JsonProperty
    private int spell2Cast;
    @JsonProperty
    private int spell3Cast;
    @JsonProperty
    private int spell4Cast;
    @JsonProperty
    private int summonSpell1Cast;
    @JsonProperty
    private int summonSpell2Cast;
    @JsonProperty
    private int superMonsterKilled;
    @JsonProperty
    private int team;
    @JsonProperty
    private int teamObjective;
    @JsonProperty
    private int timePlayed;
    @JsonProperty
    private int totalDamageDealt;
    @JsonProperty
    private int totalDamageDealtToBuildings;
    @JsonProperty
    private int totalDamageDealtToChampions;
    @JsonProperty
    private int totalDamageTaken;
    @JsonProperty
    private int totalHeal;
    @JsonProperty
    private int totalPlayerScore;
    @JsonProperty
    private int totalScoreRank;
    @JsonProperty
    private int totalTimeCrowdControlDealt;
    @JsonProperty
    private int totalUnitsHealed;
    @JsonProperty
    private int tripleKills;
    @JsonProperty
    private int trueDamageDealtPlayer;
    @JsonProperty
    private int trueDamageDealtToChampions;
    @JsonProperty
    private int trueDamageTaken;
    @JsonProperty
    private int turretsKilled;
    @JsonProperty
    private int unrealKills;
    @JsonProperty
    private int victoryPointTotal;
    @JsonProperty
    private int visionWardsBought;
    @JsonProperty
    private int wardKilled;
    @JsonProperty
    private int wardPlaced;
    @JsonProperty
    private boolean win;

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getBarracksKilled() {
        return barracksKilled;
    }

    public void setBarracksKilled(int barracksKilled) {
        this.barracksKilled = barracksKilled;
    }

    public int getBountyLevel() {
        return bountyLevel;
    }

    public void setBountyLevel(int bountyLevel) {
        this.bountyLevel = bountyLevel;
    }

    public int getChampionsKilled() {
        return championsKilled;
    }

    public void setChampionsKilled(int championsKilled) {
        this.championsKilled = championsKilled;
    }

    public int getCombatPlayerScore() {
        return combatPlayerScore;
    }

    public void setCombatPlayerScore(int combatPlayerScore) {
        this.combatPlayerScore = combatPlayerScore;
    }

    public int getConsumablesPurchased() {
        return consumablesPurchased;
    }

    public void setConsumablesPurchased(int consumablesPurchased) {
        this.consumablesPurchased = consumablesPurchased;
    }

    public int getDamageDealtPlayer() {
        return damageDealtPlayer;
    }

    public void setDamageDealtPlayer(int damageDealtPlayer) {
        this.damageDealtPlayer = damageDealtPlayer;
    }

    public int getDoubleKills() {
        return doubleKills;
    }

    public void setDoubleKills(int doubleKills) {
        this.doubleKills = doubleKills;
    }

    public int getFirstBlood() {
        return firstBlood;
    }

    public void setFirstBlood(int firstBlood) {
        this.firstBlood = firstBlood;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(int goldEarned) {
        this.goldEarned = goldEarned;
    }

    public int getGoldSpent() {
        return goldSpent;
    }

    public void setGoldSpent(int goldSpent) {
        this.goldSpent = goldSpent;
    }

    public int getItem0() {
        return item0;
    }

    public void setItem0(int item0) {
        this.item0 = item0;
    }

    public int getItem1() {
        return item1;
    }

    public void setItem1(int item1) {
        this.item1 = item1;
    }

    public int getItem2() {
        return item2;
    }

    public void setItem2(int item2) {
        this.item2 = item2;
    }

    public int getItem3() {
        return item3;
    }

    public void setItem3(int item3) {
        this.item3 = item3;
    }

    public int getItem4() {
        return item4;
    }

    public void setItem4(int item4) {
        this.item4 = item4;
    }

    public int getItem5() {
        return item5;
    }

    public void setItem5(int item5) {
        this.item5 = item5;
    }

    public int getItem6() {
        return item6;
    }

    public void setItem6(int item6) {
        this.item6 = item6;
    }

    public int getItemsPurchased() {
        return itemsPurchased;
    }

    public void setItemsPurchased(int itemsPurchased) {
        this.itemsPurchased = itemsPurchased;
    }

    public int getKillingSprees() {
        return killingSprees;
    }

    public void setKillingSprees(int killingSprees) {
        this.killingSprees = killingSprees;
    }

    public int getLargestKillingSpree() {
        return largestKillingSpree;
    }

    public void setLargestKillingSpree(int largestKillingSpree) {
        this.largestKillingSpree = largestKillingSpree;
    }

    public int getLargestCriticalStrike() {
        return largestCriticalStrike;
    }

    public void setLargestCriticalStrike(int largestCriticalStrike) {
        this.largestCriticalStrike = largestCriticalStrike;
    }

    public int getLargestMultiKill() {
        return largestMultiKill;
    }

    public void setLargestMultiKill(int largestMultiKill) {
        this.largestMultiKill = largestMultiKill;
    }

    public int getLegendaryItemsCreated() {
        return legendaryItemsCreated;
    }

    public void setLegendaryItemsCreated(int legendaryItemsCreated) {
        this.legendaryItemsCreated = legendaryItemsCreated;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMagicDamageDealtPlayer() {
        return magicDamageDealtPlayer;
    }

    public void setMagicDamageDealtPlayer(int magicDamageDealtPlayer) {
        this.magicDamageDealtPlayer = magicDamageDealtPlayer;
    }

    public int getMagicDamageDealtToChampions() {
        return magicDamageDealtToChampions;
    }

    public void setMagicDamageDealtToChampions(int magicDamageDealtToChampions) {
        this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    }

    public int getMagicDamageTaken() {
        return magicDamageTaken;
    }

    public void setMagicDamageTaken(int magicDamageTaken) {
        this.magicDamageTaken = magicDamageTaken;
    }

    public int getMinionsDenied() {
        return minionsDenied;
    }

    public void setMinionsDenied(int minionsDenied) {
        this.minionsDenied = minionsDenied;
    }

    public int getMinionsKilled() {
        return minionsKilled;
    }

    public void setMinionsKilled(int minionsKilled) {
        this.minionsKilled = minionsKilled;
    }

    public int getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    public void setNeutralMinionsKilled(int neutralMinionsKilled) {
        this.neutralMinionsKilled = neutralMinionsKilled;
    }

    public int getNeutralMinionsKilledEnemyJungle() {
        return neutralMinionsKilledEnemyJungle;
    }

    public void setNeutralMinionsKilledEnemyJungle(int neutralMinionsKilledEnemyJungle) {
        this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
    }

    public int getNeutralMinionsKilledYourJungle() {
        return neutralMinionsKilledYourJungle;
    }

    public void setNeutralMinionsKilledYourJungle(int neutralMinionsKilledYourJungle) {
        this.neutralMinionsKilledYourJungle = neutralMinionsKilledYourJungle;
    }

    public int getNexusKilled() {
        return nexusKilled;
    }

    public void setNexusKilled(int nexusKilled) {
        this.nexusKilled = nexusKilled;
    }

    public int getNodeCapture() {
        return nodeCapture;
    }

    public void setNodeCapture(int nodeCapture) {
        this.nodeCapture = nodeCapture;
    }

    public int getNodeCaptureAssist() {
        return nodeCaptureAssist;
    }

    public void setNodeCaptureAssist(int nodeCaptureAssist) {
        this.nodeCaptureAssist = nodeCaptureAssist;
    }

    public int getNodeNeutralize() {
        return nodeNeutralize;
    }

    public void setNodeNeutralize(int nodeNeutralize) {
        this.nodeNeutralize = nodeNeutralize;
    }

    public int getNodeNeutralizeAssist() {
        return nodeNeutralizeAssist;
    }

    public void setNodeNeutralizeAssist(int nodeNeutralizeAssist) {
        this.nodeNeutralizeAssist = nodeNeutralizeAssist;
    }

    public int getNumDeaths() {
        return numDeaths;
    }

    public void setNumDeaths(int numDeaths) {
        this.numDeaths = numDeaths;
    }

    public int getNumItemsBought() {
        return numItemsBought;
    }

    public void setNumItemsBought(int numItemsBought) {
        this.numItemsBought = numItemsBought;
    }

    public int getObjectivePlayerScore() {
        return objectivePlayerScore;
    }

    public void setObjectivePlayerScore(int objectivePlayerScore) {
        this.objectivePlayerScore = objectivePlayerScore;
    }

    public int getPentaKills() {
        return pentaKills;
    }

    public void setPentaKills(int pentaKills) {
        this.pentaKills = pentaKills;
    }

    public int getPhysicalDamageDealtPlayer() {
        return physicalDamageDealtPlayer;
    }

    public void setPhysicalDamageDealtPlayer(int physicalDamageDealtPlayer) {
        this.physicalDamageDealtPlayer = physicalDamageDealtPlayer;
    }

    public int getPhysicalDamageDealtToChampions() {
        return physicalDamageDealtToChampions;
    }

    public void setPhysicalDamageDealtToChampions(int physicalDamageDealtToChampions) {
        this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    }

    public int getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    public void setPhysicalDamageTaken(int physicalDamageTaken) {
        this.physicalDamageTaken = physicalDamageTaken;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(int playerRole) {
        this.playerRole = playerRole;
    }

    public int getPlayerScore0() {
        return playerScore0;
    }

    public void setPlayerScore0(int playerScore0) {
        this.playerScore0 = playerScore0;
    }

    public int getPlayerScore1() {
        return playerScore1;
    }

    public void setPlayerScore1(int playerScore1) {
        this.playerScore1 = playerScore1;
    }

    public int getPlayerScore2() {
        return playerScore2;
    }

    public void setPlayerScore2(int playerScore2) {
        this.playerScore2 = playerScore2;
    }

    public int getPlayerScore3() {
        return playerScore3;
    }

    public void setPlayerScore3(int playerScore3) {
        this.playerScore3 = playerScore3;
    }

    public int getPlayerScore4() {
        return playerScore4;
    }

    public void setPlayerScore4(int playerScore4) {
        this.playerScore4 = playerScore4;
    }

    public int getPlayerScore5() {
        return playerScore5;
    }

    public void setPlayerScore5(int playerScore5) {
        this.playerScore5 = playerScore5;
    }

    public int getPlayerScore6() {
        return playerScore6;
    }

    public void setPlayerScore6(int playerScore6) {
        this.playerScore6 = playerScore6;
    }

    public int getPlayerScore7() {
        return playerScore7;
    }

    public void setPlayerScore7(int playerScore7) {
        this.playerScore7 = playerScore7;
    }

    public int getPlayerScore8() {
        return playerScore8;
    }

    public void setPlayerScore8(int playerScore8) {
        this.playerScore8 = playerScore8;
    }

    public int getPlayerScore9() {
        return playerScore9;
    }

    public void setPlayerScore9(int playerScore9) {
        this.playerScore9 = playerScore9;
    }

    public int getQuadraKills() {
        return quadraKills;
    }

    public void setQuadraKills(int quadraKills) {
        this.quadraKills = quadraKills;
    }

    public int getSightWardsBought() {
        return sightWardsBought;
    }

    public void setSightWardsBought(int sightWardsBought) {
        this.sightWardsBought = sightWardsBought;
    }

    public int getSpell1Cast() {
        return spell1Cast;
    }

    public void setSpell1Cast(int spell1Cast) {
        this.spell1Cast = spell1Cast;
    }

    public int getSpell2Cast() {
        return spell2Cast;
    }

    public void setSpell2Cast(int spell2Cast) {
        this.spell2Cast = spell2Cast;
    }

    public int getSpell3Cast() {
        return spell3Cast;
    }

    public void setSpell3Cast(int spell3Cast) {
        this.spell3Cast = spell3Cast;
    }

    public int getSpell4Cast() {
        return spell4Cast;
    }

    public void setSpell4Cast(int spell4Cast) {
        this.spell4Cast = spell4Cast;
    }

    public int getSummonSpell1Cast() {
        return summonSpell1Cast;
    }

    public void setSummonSpell1Cast(int summonSpell1Cast) {
        this.summonSpell1Cast = summonSpell1Cast;
    }

    public int getSummonSpell2Cast() {
        return summonSpell2Cast;
    }

    public void setSummonSpell2Cast(int summonSpell2Cast) {
        this.summonSpell2Cast = summonSpell2Cast;
    }

    public int getSuperMonsterKilled() {
        return superMonsterKilled;
    }

    public void setSuperMonsterKilled(int superMonsterKilled) {
        this.superMonsterKilled = superMonsterKilled;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getTeamObjective() {
        return teamObjective;
    }

    public void setTeamObjective(int teamObjective) {
        this.teamObjective = teamObjective;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public void setTotalDamageDealt(int totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    public int getTotalDamageDealtToBuildings() {
        return totalDamageDealtToBuildings;
    }

    public void setTotalDamageDealtToBuildings(int totalDamageDealtToBuildings) {
        this.totalDamageDealtToBuildings = totalDamageDealtToBuildings;
    }

    public int getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) {
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public void setTotalDamageTaken(int totalDamageTaken) {
        this.totalDamageTaken = totalDamageTaken;
    }

    public int getTotalHeal() {
        return totalHeal;
    }

    public void setTotalHeal(int totalHeal) {
        this.totalHeal = totalHeal;
    }

    public int getTotalPlayerScore() {
        return totalPlayerScore;
    }

    public void setTotalPlayerScore(int totalPlayerScore) {
        this.totalPlayerScore = totalPlayerScore;
    }

    public int getTotalScoreRank() {
        return totalScoreRank;
    }

    public void setTotalScoreRank(int totalScoreRank) {
        this.totalScoreRank = totalScoreRank;
    }

    public int getTotalTimeCrowdControlDealt() {
        return totalTimeCrowdControlDealt;
    }

    public void setTotalTimeCrowdControlDealt(int totalTimeCrowdControlDealt) {
        this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
    }

    public int getTotalUnitsHealed() {
        return totalUnitsHealed;
    }

    public void setTotalUnitsHealed(int totalUnitsHealed) {
        this.totalUnitsHealed = totalUnitsHealed;
    }

    public int getTripleKills() {
        return tripleKills;
    }

    public void setTripleKills(int tripleKills) {
        this.tripleKills = tripleKills;
    }

    public int getTrueDamageDealtPlayer() {
        return trueDamageDealtPlayer;
    }

    public void setTrueDamageDealtPlayer(int trueDamageDealtPlayer) {
        this.trueDamageDealtPlayer = trueDamageDealtPlayer;
    }

    public int getTrueDamageDealtToChampions() {
        return trueDamageDealtToChampions;
    }

    public void setTrueDamageDealtToChampions(int trueDamageDealtToChampions) {
        this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    }

    public int getTrueDamageTaken() {
        return trueDamageTaken;
    }

    public void setTrueDamageTaken(int trueDamageTaken) {
        this.trueDamageTaken = trueDamageTaken;
    }

    public int getTurretsKilled() {
        return turretsKilled;
    }

    public void setTurretsKilled(int turretsKilled) {
        this.turretsKilled = turretsKilled;
    }

    public int getUnrealKills() {
        return unrealKills;
    }

    public void setUnrealKills(int unrealKills) {
        this.unrealKills = unrealKills;
    }

    public int getVictoryPointTotal() {
        return victoryPointTotal;
    }

    public void setVictoryPointTotal(int victoryPointTotal) {
        this.victoryPointTotal = victoryPointTotal;
    }

    public int getVisionWardsBought() {
        return visionWardsBought;
    }

    public void setVisionWardsBought(int visionWardsBought) {
        this.visionWardsBought = visionWardsBought;
    }

    public int getWardKilled() {
        return wardKilled;
    }

    public void setWardKilled(int wardKilled) {
        this.wardKilled = wardKilled;
    }

    public int getWardPlaced() {
        return wardPlaced;
    }

    public void setWardPlaced(int wardPlaced) {
        this.wardPlaced = wardPlaced;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
