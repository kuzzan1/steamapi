package main.riot.domain.match;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class ParticipantStats {
    @JsonProperty
    private long assist;
    @JsonProperty
    private long champLevel;
    @JsonProperty
    private long combatPlayerScore;
    @JsonProperty
    private long deaths;
    @JsonProperty
    private long doubleKills;
    @JsonProperty
    private boolean firstBloodAssist;
    @JsonProperty
    private boolean firstBloodKill;
    @JsonProperty
    private boolean firstInhibitorAssist;
    @JsonProperty
    private boolean firstInhibitorKill;
    @JsonProperty
    private boolean firstTowerAssist;
    @JsonProperty
    private boolean firstTowerKill;
    @JsonProperty
    private long goldEarned;
    @JsonProperty
    private long goldSpent;
    @JsonProperty
    private long inhibitorKills;
    @JsonProperty
    private long item0;
    @JsonProperty
    private long item1;
    @JsonProperty
    private long item2;
    @JsonProperty
    private long item3;
    @JsonProperty
    private long item4;
    @JsonProperty
    private long item5;
    @JsonProperty
    private long item6;
    @JsonProperty
    private long killingSprees;
    @JsonProperty
    private long kills;
    @JsonProperty
    private long largestCriticalStrike;
    @JsonProperty
    private long largestKillingSpree;
    @JsonProperty
    private long largestMultiKill;
    @JsonProperty
    private long magicDamageDealt;
    @JsonProperty
    private long magicDamageDealtToChampions;
    @JsonProperty
    private long magicDamageTaken;
    @JsonProperty
    private long minionsKilled;
    @JsonProperty
    private long neutralMinionsKilled;
    @JsonProperty
    private long neutralMinionsKilledEnemyJungle;
    @JsonProperty
    private long neutralMinionsKilledTeamJungle;
    @JsonProperty
    private long nodeCapture;
    @JsonProperty
    private long nodeCaptureAssist;
    @JsonProperty
    private long nodeNeutralizeAssist;
    @JsonProperty
    private long objectivePlayerScore;
    @JsonProperty
    private long pentaKills;
    @JsonProperty
    private long physicalDamageDealt;
    @JsonProperty
    private long physicalDamageDealtToChampions;
    @JsonProperty
    private long physicalDamageTaken;
    @JsonProperty
    private long quadraKills;
    @JsonProperty
    private long sightWardsBoughtInGame;
    @JsonProperty
    private long teamObjective;
    @JsonProperty
    private long totalDamageDealt;
    @JsonProperty
    private long totalDamageDealtToChampions;
    @JsonProperty
    private long totalDamageTaken;
    @JsonProperty
    private long totalHeal;
    @JsonProperty
    private long totalPlayerScore;
    @JsonProperty
    private long totalScoreRank;
    @JsonProperty
    private long totalTimeCrowdControlDealt;
    @JsonProperty
    private long totalUnitsHealed;
    @JsonProperty
    private long towerKills;
    @JsonProperty
    private long tripleKills;
    @JsonProperty
    private long trueDamageDealt;
    @JsonProperty
    private long trueDamageDealtToChampions;
    @JsonProperty
    private long trueDamageTaken;
    @JsonProperty
    private long unrealKills;
    @JsonProperty
    private long visionWardsBoughtInGame;
    @JsonProperty
    private long wardsKilled;
    @JsonProperty
    private long wardsPlaced;
    @JsonProperty
    private boolean winner;

    public long getAssist() {
        return assist;
    }

    public void setAssist( long assist ) {
        this.assist = assist;
    }

    public long getChampLevel() {
        return champLevel;
    }

    public void setChampLevel( long champLevel ) {
        this.champLevel = champLevel;
    }

    public long getCombatPlayerScore() {
        return combatPlayerScore;
    }

    public void setCombatPlayerScore( long combatPlayerScore ) {
        this.combatPlayerScore = combatPlayerScore;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths( long deaths ) {
        this.deaths = deaths;
    }

    public long getDoubleKills() {
        return doubleKills;
    }

    public void setDoubleKills( long doubleKills ) {
        this.doubleKills = doubleKills;
    }

    public boolean isFirstBloodAssist() {
        return firstBloodAssist;
    }

    public void setFirstBloodAssist( boolean firstBloodAssist ) {
        this.firstBloodAssist = firstBloodAssist;
    }

    public boolean isFirstBloodKill() {
        return firstBloodKill;
    }

    public void setFirstBloodKill( boolean firstBloodKill ) {
        this.firstBloodKill = firstBloodKill;
    }

    public boolean isFirstInhibitorAssist() {
        return firstInhibitorAssist;
    }

    public void setFirstInhibitorAssist( boolean firstInhibitorAssist ) {
        this.firstInhibitorAssist = firstInhibitorAssist;
    }

    public boolean isFirstInhibitorKill() {
        return firstInhibitorKill;
    }

    public void setFirstInhibitorKill( boolean firstInhibitorKill ) {
        this.firstInhibitorKill = firstInhibitorKill;
    }

    public boolean isFirstTowerAssist() {
        return firstTowerAssist;
    }

    public void setFirstTowerAssist( boolean firstTowerAssist ) {
        this.firstTowerAssist = firstTowerAssist;
    }

    public boolean isFirstTowerKill() {
        return firstTowerKill;
    }

    public void setFirstTowerKill( boolean firstTowerKill ) {
        this.firstTowerKill = firstTowerKill;
    }

    public long getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned( long goldEarned ) {
        this.goldEarned = goldEarned;
    }

    public long getGoldSpent() {
        return goldSpent;
    }

    public void setGoldSpent( long goldSpent ) {
        this.goldSpent = goldSpent;
    }

    public long getInhibitorKills() {
        return inhibitorKills;
    }

    public void setInhibitorKills( long inhibitorKills ) {
        this.inhibitorKills = inhibitorKills;
    }

    public long getItem0() {
        return item0;
    }

    public void setItem0( long item0 ) {
        this.item0 = item0;
    }

    public long getItem1() {
        return item1;
    }

    public void setItem1( long item1 ) {
        this.item1 = item1;
    }

    public long getItem2() {
        return item2;
    }

    public void setItem2( long item2 ) {
        this.item2 = item2;
    }

    public long getItem3() {
        return item3;
    }

    public void setItem3( long item3 ) {
        this.item3 = item3;
    }

    public long getItem4() {
        return item4;
    }

    public void setItem4( long item4 ) {
        this.item4 = item4;
    }

    public long getItem5() {
        return item5;
    }

    public void setItem5( long item5 ) {
        this.item5 = item5;
    }

    public long getItem6() {
        return item6;
    }

    public void setItem6( long item6 ) {
        this.item6 = item6;
    }

    public long getKillingSprees() {
        return killingSprees;
    }

    public void setKillingSprees( long killingSprees ) {
        this.killingSprees = killingSprees;
    }

    public long getKills() {
        return kills;
    }

    public void setKills( long kills ) {
        this.kills = kills;
    }

    public long getLargestCriticalStrike() {
        return largestCriticalStrike;
    }

    public void setLargestCriticalStrike( long largestCriticalStrike ) {
        this.largestCriticalStrike = largestCriticalStrike;
    }

    public long getLargestKillingSpree() {
        return largestKillingSpree;
    }

    public void setLargestKillingSpree( long largestKillingSpree ) {
        this.largestKillingSpree = largestKillingSpree;
    }

    public long getLargestMultiKill() {
        return largestMultiKill;
    }

    public void setLargestMultiKill( long largestMultiKill ) {
        this.largestMultiKill = largestMultiKill;
    }

    public long getMagicDamageDealt() {
        return magicDamageDealt;
    }

    public void setMagicDamageDealt( long magicDamageDealt ) {
        this.magicDamageDealt = magicDamageDealt;
    }

    public long getMagicDamageDealtToChampions() {
        return magicDamageDealtToChampions;
    }

    public void setMagicDamageDealtToChampions( long magicDamageDealtToChampions ) {
        this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    }

    public long getMagicDamageTaken() {
        return magicDamageTaken;
    }

    public void setMagicDamageTaken( long magicDamageTaken ) {
        this.magicDamageTaken = magicDamageTaken;
    }

    public long getMinionsKilled() {
        return minionsKilled;
    }

    public void setMinionsKilled( long minionsKilled ) {
        this.minionsKilled = minionsKilled;
    }

    public long getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    public void setNeutralMinionsKilled( long neutralMinionsKilled ) {
        this.neutralMinionsKilled = neutralMinionsKilled;
    }

    public long getNeutralMinionsKilledEnemyJungle() {
        return neutralMinionsKilledEnemyJungle;
    }

    public void setNeutralMinionsKilledEnemyJungle( long neutralMinionsKilledEnemyJungle ) {
        this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
    }

    public long getNeutralMinionsKilledTeamJungle() {
        return neutralMinionsKilledTeamJungle;
    }

    public void setNeutralMinionsKilledTeamJungle( long neutralMinionsKilledTeamJungle ) {
        this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
    }

    public long getNodeCapture() {
        return nodeCapture;
    }

    public void setNodeCapture( long nodeCapture ) {
        this.nodeCapture = nodeCapture;
    }

    public long getNodeCaptureAssist() {
        return nodeCaptureAssist;
    }

    public void setNodeCaptureAssist( long nodeCaptureAssist ) {
        this.nodeCaptureAssist = nodeCaptureAssist;
    }

    public long getNodeNeutralizeAssist() {
        return nodeNeutralizeAssist;
    }

    public void setNodeNeutralizeAssist( long nodeNeutralizeAssist ) {
        this.nodeNeutralizeAssist = nodeNeutralizeAssist;
    }

    public long getObjectivePlayerScore() {
        return objectivePlayerScore;
    }

    public void setObjectivePlayerScore( long objectivePlayerScore ) {
        this.objectivePlayerScore = objectivePlayerScore;
    }

    public long getPentaKills() {
        return pentaKills;
    }

    public void setPentaKills( long pentaKills ) {
        this.pentaKills = pentaKills;
    }

    public long getPhysicalDamageDealt() {
        return physicalDamageDealt;
    }

    public void setPhysicalDamageDealt( long physicalDamageDealt ) {
        this.physicalDamageDealt = physicalDamageDealt;
    }

    public long getPhysicalDamageDealtToChampions() {
        return physicalDamageDealtToChampions;
    }

    public void setPhysicalDamageDealtToChampions( long physicalDamageDealtToChampions ) {
        this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    }

    public long getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    public void setPhysicalDamageTaken( long physicalDamageTaken ) {
        this.physicalDamageTaken = physicalDamageTaken;
    }

    public long getQuadraKills() {
        return quadraKills;
    }

    public void setQuadraKills( long quadraKills ) {
        this.quadraKills = quadraKills;
    }

    public long getSightWardsBoughtInGame() {
        return sightWardsBoughtInGame;
    }

    public void setSightWardsBoughtInGame( long sightWardsBoughtInGame ) {
        this.sightWardsBoughtInGame = sightWardsBoughtInGame;
    }

    public long getTeamObjective() {
        return teamObjective;
    }

    public void setTeamObjective( long teamObjective ) {
        this.teamObjective = teamObjective;
    }

    public long getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public void setTotalDamageDealt( long totalDamageDealt ) {
        this.totalDamageDealt = totalDamageDealt;
    }

    public long getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public void setTotalDamageDealtToChampions( long totalDamageDealtToChampions ) {
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    }

    public long getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public void setTotalDamageTaken( long totalDamageTaken ) {
        this.totalDamageTaken = totalDamageTaken;
    }

    public long getTotalHeal() {
        return totalHeal;
    }

    public void setTotalHeal( long totalHeal ) {
        this.totalHeal = totalHeal;
    }

    public long getTotalPlayerScore() {
        return totalPlayerScore;
    }

    public void setTotalPlayerScore( long totalPlayerScore ) {
        this.totalPlayerScore = totalPlayerScore;
    }

    public long getTotalScoreRank() {
        return totalScoreRank;
    }

    public void setTotalScoreRank( long totalScoreRank ) {
        this.totalScoreRank = totalScoreRank;
    }

    public long getTotalTimeCrowdControlDealt() {
        return totalTimeCrowdControlDealt;
    }

    public void setTotalTimeCrowdControlDealt( long totalTimeCrowdControlDealt ) {
        this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
    }

    public long getTotalUnitsHealed() {
        return totalUnitsHealed;
    }

    public void setTotalUnitsHealed( long totalUnitsHealed ) {
        this.totalUnitsHealed = totalUnitsHealed;
    }

    public long getTowerKills() {
        return towerKills;
    }

    public void setTowerKills( long towerKills ) {
        this.towerKills = towerKills;
    }

    public long getTripleKills() {
        return tripleKills;
    }

    public void setTripleKills( long tripleKills ) {
        this.tripleKills = tripleKills;
    }

    public long getTrueDamageDealt() {
        return trueDamageDealt;
    }

    public void setTrueDamageDealt( long trueDamageDealt ) {
        this.trueDamageDealt = trueDamageDealt;
    }

    public long getTrueDamageDealtToChampions() {
        return trueDamageDealtToChampions;
    }

    public void setTrueDamageDealtToChampions( long trueDamageDealtToChampions ) {
        this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    }

    public long getTrueDamageTaken() {
        return trueDamageTaken;
    }

    public void setTrueDamageTaken( long trueDamageTaken ) {
        this.trueDamageTaken = trueDamageTaken;
    }

    public long getUnrealKills() {
        return unrealKills;
    }

    public void setUnrealKills( long unrealKills ) {
        this.unrealKills = unrealKills;
    }

    public long getVisionWardsBoughtInGame() {
        return visionWardsBoughtInGame;
    }

    public void setVisionWardsBoughtInGame( long visionWardsBoughtInGame ) {
        this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    }

    public long getWardsKilled() {
        return wardsKilled;
    }

    public void setWardsKilled( long wardsKilled ) {
        this.wardsKilled = wardsKilled;
    }

    public long getWardsPlaced() {
        return wardsPlaced;
    }

    public void setWardsPlaced( long wardsPlaced ) {
        this.wardsPlaced = wardsPlaced;
    }

    public boolean getWinner() {
        return winner;
    }

    public void setWinner( boolean winner ) {
        this.winner = winner;
    }
}
