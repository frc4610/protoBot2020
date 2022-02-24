// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.utils;

import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.UTILS.DPadButton;

public class XboxControllerExtended extends XboxController {

  private final DPadButton[] dpadButtons;

  public XboxControllerExtended(int port) {
    super(port);
    dpadButtons = new DPadButton[DPadButton.Direction.values().length];
    for (DPadButton.Direction dir : DPadButton.Direction.values()) {
      dpadButtons[dir.ordinal()] = new DPadButton(this, dir);
    }
  }

  public DPadButton getDPadButton(DPadButton.Direction direction) {
    return dpadButtons[direction.ordinal()];
  }

  public boolean getDPadUp() {
    return getDPadButton(DPadButton.Direction.UP).get();
  }

  public boolean getDPadLeft() {
    return getDPadButton(DPadButton.Direction.LEFT).get();
  }

  public boolean getDPadRight() {
    return getDPadButton(DPadButton.Direction.RIGHT).get();
  }

  public boolean getDPadDown() {
    return getDPadButton(DPadButton.Direction.DOWN).get();
  }
}