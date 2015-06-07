package me.Coderforlife.Tekkit;

public enum Command
{
  VERSION("version"),  MENU("help"),  RELOAD("reload");
  
  private String command;
  
  private Command(String command)
  {
    this.command = command;
  }
  
  public String getCommandName()
  {
    return this.command;
  }
}
