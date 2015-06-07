package me.Coderforlife.Tekkit;

public enum EntityAction
{
  Crouch(
    1),  Uncrouch(
  
    2),  Leave_Bed(
  
    3),  Sprint(
  
    4),  Sprint_Stop(
  
    5);
  
  private int id;
  private String name;
  
  private EntityAction(int id)
  {
    this.id = id;
  }
  
  public int getID()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
}
