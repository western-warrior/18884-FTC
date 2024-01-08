public class path
{
  private MechanumDrive g;
  
  public path(MecanumDrive j)
  {
    g = new MechanumDrive(hardwareMap, new Pose2d());
  }

  public void gotoMiddle()
  {
    g.actionBuilder(new Pose2d())
      .lineToX(40)
  }

  public vo
  
