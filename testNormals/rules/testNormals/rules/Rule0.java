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
		class1.setX(5.0);
		class1.setY(5.0);
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
		Vector3D vec23 = vec3.subtract(vec2);
		
		Vector3D vec_res = vec12.add(vec23);
		vec_res = vec_res.normalize();
		
		Line vis = Line.create();
		
		vis.setStartPoint(class2);
		Class1 c4 = Class1.create();
		
		c4.setX(class2.getX().getValue() + vec_res.getX());
		c4.setY(class2.getY().getValue() + vec_res.getY());
		c4.setZ(class2.getZ().getValue() + vec_res.getZ());

		vis.setEndPoint(c4);
		
		G g2 = G.create();
		g2.getGeometric().add(vis);
		Component.create().setShape(g2);	
		
		
	

	}

}