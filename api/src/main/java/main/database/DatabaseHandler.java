package main.database;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.gen.ast.Table;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;
import main.toornament.domain.Match;
import main.toornament.domain.Participant;
import main.toornament.domain.Player;
import main.toornament.domain.Tournament;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jonas on 2016-02-01.
 */
@Component
public class DatabaseHandler {

    public static final RethinkDB r = RethinkDB.r;

    public void addSingleTournamentToDB( Tournament tournament ) {
        new Thread( () -> {
            Connection conn = null;

            try {
                conn = r.connection().hostname( "176.58.126.231" ).port( 28015 ).authKey( "bajskorv" ).connect();
                Table table = r.db( "data" ).table( "tournament" );

                Cursor<Tournament> tournamentId = table.filter( row -> row.g( "tournamentId" ).eq( tournament.getTournamentId() ) ).run( conn );
                if( tournamentId.hasNext() ) {
                    table.update( tournament ).run( conn );
                    System.out.println( "Updated Tournament: " + tournament.getName() );
                } else {
                    table.insert( tournament ).optArg( "conflict", "replace" ).run( conn );
                    System.out.println( "Inserted Tournament: " + tournament.getName() );
                }

            } catch ( Exception e ) {
                System.err.println( "Error: Tournament failed" );
            } finally {
                conn.close();
            }
        } ).start();

    }

    public void addMatch( Match match ) {
        new Thread( () -> {
            Connection conn = null;

            try {
                conn = r.connection().hostname( "176.58.126.231" ).port( 28015 ).authKey( "bajskorv" ).connect();
                Table table = r.db( "data" ).table( "match" );

                Cursor<Match> matchId = table.filter( row -> row.g( "id" ).eq( match.getId() ) ).run( conn );
                if( matchId.hasNext() ) {
                    table.update( match ).run( conn );
                    System.out.println( "Updated Match: " + match.getId() );
                } else {
                    table.insert( match ).optArg( "conflict", "replace" ).run( conn );
                    System.out.println( "Inserted Match: " + match.getId() );

                }

            } catch ( Exception e ) {
                System.err.println( "Error: Match failed" );
            } finally {
                conn.close();
            }
        } ).start();
    }

    public void addTeam( Participant team ) {
        new Thread( () -> {
            Connection conn = null;

            try {
                conn = r.connection().hostname( "176.58.126.231" ).port( 28015 ).authKey( "bajskorv" ).connect();
                Table table = r.db( "data" ).table( "team" );

                Cursor<Match> matchId = table.filter( row -> row.g( "id" ).eq( team.getId() ) ).run( conn );
                if( matchId.hasNext() ) {
                    table.update( team ).run( conn );
                    System.out.println( "Updated Team: " + team.getName() );
                } else {
                    table.insert( team ).optArg( "conflict", "replace" ).run( conn );
                    System.out.println( "Inserted Team: " + team.getName() );

                }

            } catch ( Exception e ) {
                System.err.println( "Error: Team failed" );
            } finally {
                conn.close();
            }
        } ).start();
    }

    public void addPlayer( List<Player> players, Participant team ) {
        new Thread( () -> {
            Connection conn = null;

            try {
                conn = r.connection().hostname( "176.58.126.231" ).port( 28015 ).authKey( "bajskorv" ).connect();
                Table table = r.db( "data" ).table( "player" );
                for( Player player : players ) {
                    if( player.getName() != null ) {
                        player.setTeam(team);
                        Cursor<Match> playerId = table.filter( row -> row.g( "name" ).eq( player.getName() ) ).run( conn );
                        if( playerId.hasNext() ) {
                            table.update( player ).run( conn );
                            System.out.println( "Updated Player: " + player.getName() );
                        } else {
                            table.insert( player ).optArg( "conflict", "replace" ).run( conn );
                            System.out.println( "Inserted Player: " + player.getName() );

                        }
                    }
                }

            } catch ( Exception e ) {
                System.err.println( "Error: Player failed" );
            } finally {
                conn.close();
            }
        } ).start();
    }
}
