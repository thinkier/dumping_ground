package io.github.loldatsec.mcplugins.gtowny.test.chunks;

import org.reborncraft.gtowny.data.local.ChunkLocation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ChunkTest {
	public static void main(String[] args) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new File("ChunkTest.csv"));
			out.print("X/Z, ");
			for (int z = -50; z <= 50; z++) {
				out.print("" + z + ", ");
			}
			out.println();
			for (int x = -50; x <= 50; x++) {
				out.print("" + x + ", ");
				for (int z = -50; z <= 50; z++) {
					ChunkLocation c = new ChunkLocation(x, z);
					out.print("" + c.getX() + "" + c.getZ() + ", ");
				}
				out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
