package testNormals.rules;

import de.iils.dc43.core.JavaRule;
import de.iils.dc43.core.geometry.publication.Component;
import de.iils.dc43.core.geometry.publication.G;
import de.iils.dc43.core.geometry.publication.Line;
import de.iils.dc43.core.geometry.publication.PolyLine;
import de.iils.dc43.evaluation.notation.mathconstraint.mathmodel.Vector;
import tec.uom.se.NumberQuantity;
import testNormals.*;

import static tec.uom.se.quantity.Quantities.*;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import com.sun.javafx.geom.Vec3d;
import com.sun.javafx.geom.Vec3f;

import static de.iils.dc43.core.util.DC43Util.prettyPrint;

@SuppressWarnings("all")
public class Rule0 extends JavaRule {

	@Override
	public void execute() throws Exception {
		Class1 class1 = Class1.create();
		class1.setX(1.0);
		class1.setY(1.0);
		class1.setZ(0.0);
		
		Class1 class2 = Class1.create();
		class2.setX(10.0);
		class2.setY(10.0);
		class2.setZ(0.0);
		
		Class1 class3 = Class1.create();
		class3.setX(10.0);
		class3.setY(5.0);
		class3.setZ(0.0);
		
		PolyLine pl = PolyLine.create();
		pl.setStart(class1);
		
		class1.getNextPoint().add(class2);
		class2.getNextPoint().add(class3);
		class3.getNextPoint().add(class1);
		
		pl.getElement().add(class1);
		pl.getElement().add(class2);
		pl.getElement().add(class3);

		G g = G.create();
		g.getGeometric().add(pl);
		Component.create().setShape(g);	
		
		Vector3D vec1 = new Vector3D(class1.getX().getValue(), class1.getY().getValue(), class1.getZ().getValue());
		Vector3D vec2 = new Vector3D(class2.getX().getValue(), class2.getY().getValue(), class2.getZ().getValue());
		Vector3D vec3 = new Vector3D(class3.getX().getValue(), class3.getY().getValue(), class3.getZ().getValue());
		
		Vector3D vec12 = vec1.subtract(vec2);
		Vector3D vec32 = vec3.subtract(vec2);
		
		Vector3D vec_res2 = vec12.add(vec32);
		vec_res2 = vec_res2.normalize();
		
		Line vis2 = Line.create();
		
		vis2.setStartPoint(class2);
		Class1 c2 = Class1.create();
		
		c2.setX(class2.getX().getValue() + vec_res2.getX());
		c2.setY(class2.getY().getValue() + vec_res2.getY());
		c2.setZ(class2.getZ().getValue() + vec_res2.getZ());

		vis2.setEndPoint(c2);
		
		G g2 = G.create();
		g2.getGeometric().add(vis2);
		Component.create().setShape(g2);	
		
		Vector3D vec23 = vec2.subtract(vec3);
		Vector3D vec13 = vec1.subtract(vec3);
		
		Vector3D vec_res3 = vec23.add(vec13);
		vec_res3 = vec_res3.normalize();
		
		Line vis3 = Line.create();
		
		vis3.setStartPoint(class2);
		Class1 c3 = Class1.create();
		
		c3.setX(class2.getX().getValue() + vec_res3.getX());
		c3.setY(class2.getY().getValue() + vec_res3.getY());
		c3.setZ(class2.getZ().getValue() + vec_res3.getZ());

		vis3.setEndPoint(c3);
		
		G g3 = G.create();
		g3.getGeometric().add(vis3);
		Component.create().setShape(g3);
	

	}

}