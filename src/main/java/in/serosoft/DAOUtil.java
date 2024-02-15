package in.serosoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

public class DAOUtil {

	public static Map<String,String> getProjectionInstance(){
		return new HashMap<>();
	}
	
	public static <C> void transformResultListToBeanClass(Criteria criteria, Map<String, String> projections,
			Class<C> beanClass) {

		ProjectionList proList = Projections.projectionList();
		for (Map.Entry<String, String> entry : projections.entrySet()) {
			proList.add(Projections.property(entry.getKey()), entry.getValue());
		}
		criteria.setProjection(Projections.distinct(proList)).setResultTransformer(Transformers.aliasToBean(beanClass));

	}
	public static void createProjection(Criteria criteria, Map<String,String> projections) {
		ProjectionList pList=Projections.projectionList();
		
		for(Entry<String,String> entry:projections.entrySet()) {
			//String key=entry.getKey();
			//String value=entry.getValue();
			//Projection projection=Projections.property(key);
			pList.add(Projections.property(entry.getKey()),entry.getValue() );
		}
		criteria.setProjection(pList);
		criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	}
}
