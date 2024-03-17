package nckh.service.impl;

import nckh.entity.RoleEntity;
import nckh.repository.RoleRepository;
import nckh.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Map<String, String> findAll() {
		 Map<String, String> result = new HashMap<String, String>();
		 List<RoleEntity> entity = roleRepository.findAll();
		 for (RoleEntity roleEntity : entity) {
			 result.put(roleEntity.getCode(), roleEntity.getName());
		}
		 
		return result;
	}

//	@Override
//	public String deleteRole(long[] ids) {
//        
//		try {
//        	for (long id : ids) {
//    			roleRepository.deleteById(id);;
//    		}
//        	return "Succses";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "Error";
//		}
//	
//		
//	}
     
}
