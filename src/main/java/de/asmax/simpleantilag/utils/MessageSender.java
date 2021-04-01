package de.asmax.simpleantilag.utils;

public class MessageSender {

    public static String sendReloadInfoToSender() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.reloadInfoSenderDE;
        } else {
            return Messages.reloadInfoSenderEN;
        }
    }

    public static String sendReloadInfo() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.reloadInfoDE;
        } else {
            return Messages.reloadInfoEN;
        }
    }

    public static String initStableReload() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.initReloadDE;
        } else {
            return Messages.initReloadEN;
        }
    }

    public static String sendStopInfoToSender() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.stopInfoSenderDE;
        } else {
            return Messages.stopInfoSenderEN;
        }
    }

    public static String sendStopInfo() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.stopInfoDE;
        } else {
            return Messages.stopInfoEN;
        }
    }

    public static String sendShutdownKick() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.shutdownKickDE;
        } else {
            return Messages.shutdownKickEN;
        }
    }

    public static String kickRunOfTPS() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.kickRunOfTPSDE;
        } else {
            return Messages.kickRunOfTPSEN;
        }
    }

    public static String liveLag18RedLine1() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.liveLag18RedDELine1;
        } else {
            return Messages.liveLag18RedENLine1;
        }
    }

    public static String liveLag18RedLine2() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.liveLag18RedDELine2;
        } else {
            return Messages.liveLag18RedENLine2;
        }
    }

    public static String liveLag18RedLine3() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.liveLag18RedDELine3;
        } else {
            return Messages.liveLag18RedENLine3;
        }
    }

    public static String liveLag18RedLine4() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.liveLag18RedDELine4;
        } else {
            return Messages.liveLag18RedENLine4;
        }
    }

    public static String liveLag18RedLine5() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.liveLag18RedDELine5;
        } else {
            return Messages.liveLag18RedENLine5;
        }
    }

    public static String liveLag16RedLine1() {
        if(GameStateManager.Language.equalsIgnoreCase("de")) {
            return Messages.liveLag16RedDELine1;
        } else {
            return Messages.liveLag16RedENLine1;
        }
    }

}
