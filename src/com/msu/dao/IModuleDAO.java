package com.msu.dao;

import java.util.List;

import com.msu.dataobject.Module;

public interface IModuleDAO {

	public boolean insert(Module module);

	public boolean delete(Module module);

	public boolean update(Module module);

	public List<Module> getAllModules();

	public Module getModuleBySeqNo(long moduleSeqNo);

	public List<Module> getModuleByName(String moduleName);

}
