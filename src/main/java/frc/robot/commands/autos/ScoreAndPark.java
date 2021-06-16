// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.PathConverter;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ScoreAndPark extends SequentialCommandGroup {
  /** Creates a new ScoreAndPark. */
  public ScoreAndPark(Drivetrain m_drivetrain, Intake m_intake) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new InstantCommand(m_intake::openIntake, m_intake),
      new PathConverter(m_drivetrain, "output/score_and_park_pt1.wpilib.json").getCommand(),
      new WaitCommand(3.0),
      new InstantCommand(m_intake::closeIntake, m_intake),
      new PathConverter(m_drivetrain, "output/score_and_park_pt2.wpilib.json").getCommand()
    );
  }
}
