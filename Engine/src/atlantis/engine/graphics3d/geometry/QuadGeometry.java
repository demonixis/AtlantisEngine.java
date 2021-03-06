// AtlantisEngine.java - Copyright (C) Yannick Comte.
// This file is subject to the terms and conditions defined in
// file 'LICENSE', which is part of this source code package.
package atlantis.engine.graphics3d.geometry;

import atlantis.engine.graphics3d.Face3;
import atlantis.framework.Vector3;

/**
 * A plane geometry.
 * @author Yannick
 */
public class QuadGeometry extends MeshGeometry {
	
	public QuadGeometry() {
		this(1.0f, 1.0f);
	}
	
	public QuadGeometry(float width, float depth) {
		 this.width = width;
		 this.height = 0.0f;
		 this.depth = depth;

         this.vertices = new Vector3[4];
         this.vertices[0] = new Vector3(-1.0f, 0.0f, -1.0f);
         this.vertices[1] = new Vector3(1.0f, 0.0f, -1.0f);
         this.vertices[2] = new Vector3(1.0f, 0.0f, 1.0f);
         this.vertices[3] = new Vector3(-1.0f, 0.0f, 1.0f);

         this.faces = new Face3[2];
         this.faces[0] = new Face3(0, 1, 2);
         this.faces[1] = new Face3(2, 0, 3);

         computeVertices();
	}
}
