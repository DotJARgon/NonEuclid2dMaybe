package game_utils;

public class Tile {
    private Line[] walls;
    private Tile[] tiles;
    private  int[] entry;

    private static final double MAX_RAY = 256.0;

    public Tile(Line[] walls, Tile[] tiles, int[] entry) {
        if(walls.length == tiles.length && walls.length == entry.length) {
            this.walls = walls;
            this.tiles = tiles;
            this.entry = entry;
        }
        else {
            System.out.println("length of walls and tiles do not match");
        }
    }

//    public double raycast(double a) {
//
//    }
}
