import com.teamcode.MecanumDrive;

public class path
{
  private MechanumDrive g;
  
  public path(MecanumDrive j)
  {
    g = new MechanumDrive(hardwareMap, new Pose2d());
  }

  public TrajectoryActionBuilder gotoMiddle()
  {
    return g.actionBuilder(new Pose2d()).lineToX(40).build();
  }

  public Trajectory goTo()
  {
    g.TrajectoryActionBuilder(new Pose2d())
      .forward(10);
  }

  public void goToLeftSpike()
  {
    g.actionBuilder(new Pose2d()).turn(30).forward(10).build();
  }

  public TrajectoryActionBuilder goToMiddleSpike()
  {
    g.TrajectoryActionBuilder(new Pose2d())
      .turn(40)
      
  }
  
}