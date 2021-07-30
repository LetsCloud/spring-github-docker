FROM alpine:3.10
ARG PROFILE
RUN echo "Here is the build env: $PROFILE!"
