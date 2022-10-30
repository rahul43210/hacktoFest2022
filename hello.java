public static int getFreePort() {
    for (int i = 0; i < NUM_CANDIDATES; i++) {
        final int port = nextCandidatePort();
        final InetSocketAddress wildcardAddr = new InetSocketAddress(port);

        if (isTcpPortAvailable(wildcardAddr) &&
            isTcpPortAvailable(loopbackAddr) &&
            isUdpPortAvailable(wildcardAddr) &&
            isUdpPortAvailable(loopbackAddr)) {
            return port;
        }
    }

    throw new RuntimeException("unable to find a free port");
}
