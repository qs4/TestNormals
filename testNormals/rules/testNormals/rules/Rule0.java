package testNormals.rules;

import de.iils.dc43.core.JavaRule;
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
		class1.setX(0.0);
		class1.setY(0.0);
		class1.setZ(0.0);
		
		Class1 class2 = Class1.create();
		class2.setX(10.0);
		class2.setY(10.0);
		class2.setZ(0.0);
		
		 
		Vector3D vec1 = new Vector3D(class1.getX().getValue(), class1.getY().getValue(), class1.getZ().getValue());
		Vector3D vec2 = new Vector3D(class1.getX().getValue(), class1.getY().getValue(), class1.getZ().getValue());
		Vector3D vec3 = new Vector3D(0, 0, 0);
		
//		vec3 = cross( vec1, vec2);

	}

}